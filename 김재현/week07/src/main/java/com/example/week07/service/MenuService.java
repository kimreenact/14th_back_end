package com.example.week07.service;

import com.example.week07.model.Menu;
import com.example.week07.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu save(Menu menu) {
        return this.menuRepository.save(menu);
    }

    public Optional<Menu> findById(Long id) {
        return this.menuRepository.findById(id);
    }

    public List<Menu> findAll() {
        return this.menuRepository.findAll();
    }

    public void update(Long id, String name, int price, String category) {
        this.menuRepository.update(id, name, price, category);
    }
}
