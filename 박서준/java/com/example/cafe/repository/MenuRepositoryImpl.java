package com.example.cafe.repository;

import com.example.cafe.model.Menu;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.*;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    private final List<Menu> store = new ArrayList<>();
    private Long idSequence = 1L;

    @Override
    public Menu save(Menu menu) {
        menu.setId(idSequence++);
        store.add(menu);
        return menu;
    }

    @Override
    public Optional<Menu> findById(Long id) {
        for (Menu menu : store) {
            if (menu.getId().equals(id)) {
                return Optional.of(menu);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Menu> findAll() {
        return store;
    }

    @Override
    public void update(Long id, String name, int price, String category) {
        for (Menu menu : store) {
            if (menu.getId().equals(id)) {
                menu.setName(name);
                menu.setPrice(price);
                menu.setCategory(category);
            }
        }
    }
}
