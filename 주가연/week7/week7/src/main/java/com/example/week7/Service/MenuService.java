package com.example.week7.Service;

import com.example.week7.Menu;
import com.example.week7.DTO.MenuRequestDto;
import com.example.week7.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    // 생성자 주입 (DI)
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // CREATE
    public void registerMenu(MenuRequestDto requestDto) {
        Menu menu = new Menu(null, requestDto.getName(), requestDto.getPrice(), requestDto.getCategory());
        menuRepository.save(menu);
    }

    // READ (단건)
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElse(new Menu(0L, "존재하지 않는 메뉴", 0, "UNKNOWN"));
    }

    // READ (전체)
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    // UPDATE
    public void modifyMenu(Long id, MenuRequestDto requestDto) {
        menuRepository.update(id, requestDto.getName(), requestDto.getPrice(), requestDto.getCategory());
    }

    public void registerMenu(String name, int price, String category) {
    }

    public void modifyMenu(Long id, String name, int price, String category) {
    }
}