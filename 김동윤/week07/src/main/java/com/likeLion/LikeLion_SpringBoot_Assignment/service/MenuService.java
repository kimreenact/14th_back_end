package com.likeLion.LikeLion_SpringBoot_Assignment.service;

import com.likeLion.LikeLion_SpringBoot_Assignment.dto.MenuRequestDto;
import com.likeLion.LikeLion_SpringBoot_Assignment.model.Menu;
import com.likeLion.LikeLion_SpringBoot_Assignment.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu register(MenuRequestDto menuRequestDto) {
        Menu menu = new Menu(null,  menuRequestDto.getName(), menuRequestDto.getPrice(), menuRequestDto.getCategory());
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenu(Long id) {
        return menuRepository.findById(id);
    }

    public void updateMenu(Long id, MenuRequestDto menuRequestDto) {
        menuRepository.update(id,  menuRequestDto.getName(), menuRequestDto.getPrice(), menuRequestDto.getCategory());
    }
}
