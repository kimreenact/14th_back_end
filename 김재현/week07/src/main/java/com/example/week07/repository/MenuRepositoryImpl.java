package com.example.week07.repository;

import com.example.week07.model.Menu;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    private ArrayList<Menu> menus = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Menu save(Menu menu) {
        menu.setId(nextId++);
        this.menus.add(menu);
        return menu;
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return this.menus.stream().filter(menu -> menu.getId().equals(id)).findFirst();
    }

    @Override
    public List<Menu> findAll() {
        return this.menus;
    }

    @Override
    public void update(Long id, String name, int price, String category) {
        Menu menu = findById(id).get();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategory(category);
    }
}
