package com.example.cafe.service;

import com.example.cafe.dto.MenuRequestDto;
import com.example.cafe.model.Menu;
import com.example.cafe.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public Menu addMenu(MenuRequestDto dto) {
        Menu menu = new Menu(null, dto.getName(), dto.getPrice(), dto.getCategory());
        return menuRepository.save(menu);
    }

    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenu(Long id) {
        return menuRepository.findById(id);
    }

    public void updateMenu(Long id, MenuRequestDto dto) {
        menuRepository.update(id, dto.getName(), dto.getPrice(), dto.getCategory());
    }
}