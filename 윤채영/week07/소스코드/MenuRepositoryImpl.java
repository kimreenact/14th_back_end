package com.example.cafe.repository;

import com.example.cafe.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    private final List<Menu> store = new ArrayList<>();
    private Long sequence = 0L;

    @Override
    public Menu save(Menu menu) {
        menu.setId(++sequence);
        store.add(menu);
        return menu;
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return store.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Menu> findAll() {
        return new ArrayList<>(store);
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