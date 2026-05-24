package com.example.cafe.repository;

import com.example.cafe.model.Menu;
import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    Menu save(String name, int price, String category);
    Optional<Menu> findById(Long id);
    List<Menu> findAll();
    void update(Long id, String name, int price, String category);
    void delete(Long id);

}