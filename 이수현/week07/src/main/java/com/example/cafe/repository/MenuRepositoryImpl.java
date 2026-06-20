package com.example.cafe.repository;

import com.example.cafe.model.Menu;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping("/api/items")

public class MenuRepositoryImpl implements MenuRepository {

    private final List<Menu> menuList = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Menu save(String name, int price, String category) {
        Menu menu = new Menu(nextId++, name, price, category);
        menuList.add(menu);
        return menu;
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return menuList.stream()
                .filter(menu -> menu.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Menu> findAll() {
        return menuList;
    }

    @Override
    public void update(Long id, String name, int price, String category) {
        findById(id).ifPresent(menu -> {
            menu.setName(name);
            menu.setPrice(price);
            menu.setCategory(category);
        });
    }
    @Override
    public void delete(Long id) {
        menuList.removeIf(menu -> menu.getId().equals(id));
    }
}