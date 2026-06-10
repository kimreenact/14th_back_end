package com.example.week7.Controller;

import com.example.week7.DTO.MenuRequestDto;
import com.example.week7.Menu;
import com.example.week7.Service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus") // lucky 예시의 /api/items와 매칭
public class MenuRestController {

    private final MenuService menuService;

    // 생성자 주입 (DI)
    public MenuRestController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 1. CREATE — 새 메뉴 추가
    @PostMapping
    public String addMenu(@RequestBody MenuRequestDto request) {
        menuService.registerMenu(request);
        return "메뉴가 추가되었습니다!";
    }

    // 2. READ — 전체 메뉴 목록 조회
    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    // 3. READ — 특정 메뉴 상세 조회
    @GetMapping("/{id}")
    public Menu getMenuDetail(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    // 4. UPDATE — 메뉴 수정
    @PutMapping("/{id}")
    public String updateMenu(@PathVariable Long id, @RequestBody MenuRequestDto request) {
        menuService.modifyMenu(id, request);
        return "메뉴가 수정되었습니다!";
    }
}