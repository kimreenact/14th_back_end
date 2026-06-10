package com.example.week08hw.repository;

import com.example.week08hw.entity.Store;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StoreRepository {

    private final List<Store> stores = new ArrayList<>();
    private Long sequence = 1L;

    public Store save(String name) {
        Store store = new Store(sequence++, name);
        stores.add(store);
        return store;
    }

    public List<Store> findAll() {
        return stores;
    }

    public Optional<Store> findById(Long id) {
        return stores.stream()
                .filter(store -> store.getId().equals(id))
                .findFirst();
    }

    public void delete(Store store) {
        stores.remove(store);
    }
}