package com.example.cafe.service;

import com.example.cafe.model.Menu;
import com.example.cafe.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu save(Menu menu) {
        return menuRepository.save(menu);    }

    public Optional<Menu> findById(Long id) {
        return menuRepository.findById(id);    }

    public List<Menu> findAll() {
        return menuRepository.findAll();}

    public void update(Long id, String name, int price, String category) {
        menuRepository.update(id, name, price, category);
    }

    public void save(String name, int price, String category) {
        menuRepository.save(new Menu(null, name, price, category));
    }
}
