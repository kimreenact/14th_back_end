package com.example.week07hw.controller;

import com.example.week07hw.dto.MenuRequestDto;
import com.example.week07hw.model.Menu;
import com.example.week07hw.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    // 전체 메뉴 조회
    @GetMapping
    public String list(Model model) {
        model.addAttribute("menus", menuService.getAllMenus());
        return "menu-list";
    }

    // 메뉴 등록 폼
    @GetMapping("/new")
    public String createForm() {
        return "menu-form";
    }

    // 메뉴 등록 처리
    @PostMapping("/new")
    public String create(@ModelAttribute MenuRequestDto requestDto) {
        menuService.register(requestDto);
        return "redirect:/menus";
    }

    // 메뉴 상세 조회
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Menu> menu = menuService.getMenuById(id);

        if (menu.isEmpty()) {
            return "redirect:/menus";
        }

        model.addAttribute("menu", menu.get());
        return "menu-detail";
    }

    // 메뉴 수정
    // html 수정화면이 없어서 수정이 안됨 ㅠ
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Menu> menu = menuService.getMenuById(id);

        if (menu.isEmpty()) {
            return "redirect:/menus";
        }

        model.addAttribute("menu", menu.get());
        return "menu-form";
    }

    // 메뉴 수정 처리
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute MenuRequestDto requestDto) {
        menuService.updateMenu(id, requestDto);
        return "redirect:/menus/" + id;
    }
}