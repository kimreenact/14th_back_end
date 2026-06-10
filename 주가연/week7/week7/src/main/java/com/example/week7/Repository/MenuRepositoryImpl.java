package com.example.week7.Repository;

import com.example.week7.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    private static final Map<Long, Menu> store = new ConcurrentHashMap<>();
    private static final AtomicLong sequence = new AtomicLong(0);

    public MenuRepositoryImpl() {
        save(new Menu(null, "아메리카노", 2000, "COFFEE"));
        save(new Menu(null, "카페라떼", 2900, "COFFEE"));
    }

    @Override
    public Menu save(Menu menu) {
        if (menu.getId() == null) {
            menu.setId(sequence.incrementAndGet());
        }
        store.put(menu.getId(), menu);
        return menu;
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Menu> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Long id, String name, int price, String category) {
        Menu menu = store.get(id);
        if (menu != null) {
            menu.setName(name);
            menu.setPrice(price);
            menu.setCategory(category);
        }
    }
}