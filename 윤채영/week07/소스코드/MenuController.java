package com.example.cafe.controller;

import com.example.cafe.dto.MenuRequestDto;
import com.example.cafe.model.Menu;
import com.example.cafe.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/menus")
    public String menuList(Model model) {
        model.addAttribute("menus", menuService.getMenus());
        return "menu-list";
    }

    @GetMapping("/menus/{id}")
    public String menuDetail(@PathVariable Long id, Model model) {
        menuService.getMenu(id).ifPresent(menu -> model.addAttribute("menu", menu));
        return "menu-detail";
    }
    @GetMapping("/menus/new")
    public String menuForm() {
        return "menu-form";
    }
    @PostMapping("/menus/new")
    public String addMenu(@ModelAttribute MenuRequestDto dto) {
        menuService.addMenu(dto);
        return "redirect:/menus";
    }

    @GetMapping("/menus/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        menuService.getMenu(id).ifPresent(menu -> model.addAttribute("menu", menu));
        return "menu-form";
    }

    @PostMapping("/menus/{id}/edit")
    public String updateMenu(@PathVariable Long id, @ModelAttribute MenuRequestDto dto) {
        menuService.updateMenu(id, dto);
        return "redirect:/menus/" + id;
    }
}