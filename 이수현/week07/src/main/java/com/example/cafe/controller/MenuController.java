package com.example.cafe.controller;

import com.example.cafe.dto.RequestDto;
import com.example.cafe.model.Menu;
import com.example.cafe.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public String getAllMenus(Model model) {
        model.addAttribute("menus", menuService.getAllMenus());
        return "menu-list";
    }

    @GetMapping("/{id}")
    public String getMenu(@PathVariable Long id, Model model) {
        model.addAttribute("menu", menuService.getMenu(id).get());
        return "menu-detail";
    }

    @GetMapping("/new")
    public String addMenuForm() {
        return "menu-form";
    }

    @PostMapping("/new")
    public String addMenu(@ModelAttribute RequestDto request) {
        menuService.addMenu(request.getName(), request.getPrice(), request.getCategory());
        return "redirect:/menus";
    }

    @GetMapping("/{id}/edit")
    public String editMenuForm(@PathVariable Long id, Model model) {
        model.addAttribute("menu", menuService.getMenu(id).get());
        return "menu-form";
    }

    @PostMapping("/{id}/edit")
    public String updateMenu(@PathVariable Long id, @ModelAttribute RequestDto request) {
        menuService.updateMenu(id, request.getName(), request.getPrice(), request.getCategory());
        return "redirect:/menus";
    }
}