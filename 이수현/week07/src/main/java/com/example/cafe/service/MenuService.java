package com.example.cafe.service;

import com.example.cafe.repository.MenuRepository;
import com.example.cafe.model.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public void addMenu(String name, int price, String category) {
        menuRepository.save(name, price, category);
    }

    public Optional<Menu> getMenu(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다. id: " + id);
        }
        return menu;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public void updateMenu(Long id, String name, int price, String category) {
        if (menuRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다. id: " + id);
        }
        menuRepository.update(id, name, price, category);
    }

    public void deleteMenu(Long id) {
        if (menuRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다. id: " + id);
        }
        menuRepository.delete(id);
    }
}