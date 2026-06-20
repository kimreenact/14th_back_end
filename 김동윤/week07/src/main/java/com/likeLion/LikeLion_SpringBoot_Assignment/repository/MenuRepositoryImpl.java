package com.likeLion.LikeLion_SpringBoot_Assignment.repository;

import com.likeLion.LikeLion_SpringBoot_Assignment.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepositoryImpl implements MenuRepository{
    private List<Menu> menus = new ArrayList<>();

    private Long sequence = 0L;

    @Override
    public Menu save(Menu menu) {
        sequence++;
        menu.setId(sequence);
        menus.add(menu);
        return menu;
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return menus.stream().filter(menu -> menu.getId().equals(id)).findFirst();
    }

    @Override
    public List<Menu> findAll() {
        return new ArrayList<>(menus);
    }

    @Override
    public void update(Long id, String name, int price, String category) {
        findById(id).ifPresent(menu -> {
            menu.setName(name);
            menu.setPrice(price);
            menu.setCategory(category);
        });
    }
}