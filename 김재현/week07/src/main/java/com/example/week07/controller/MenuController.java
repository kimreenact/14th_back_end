package com.example.week07.controller;

import com.example.week07.dto.MenuRequestDto;
import com.example.week07.model.Menu;
import com.example.week07.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public String listMenu(Model model) {
        List<Menu> menus = this.menuService.findAll();
        model.addAttribute("menus", menus);
        return "menu-list";
    }

    @GetMapping("/{id}")
    public String listMenuDetail(Model model, @PathVariable Long id) {
        Optional<Menu> menu = this.menuService.findById(id);
        if (menu.isEmpty()) {
            return "redirect:/menus";
        }
        model.addAttribute("menu", menu.get());
        return "menu-detail";
    }

    @GetMapping("/new")
    public String newMenuForm(Model model) {
        return "menu-form";
    }

    @PostMapping("/new")
    public String newMenu(MenuRequestDto dto) {
        this.menuService.save(new Menu(null, dto.getName(), dto.getPrice(), dto.getCategory()));
        return "redirect:/menus";
    }

    @GetMapping("/{id}/edit")
    public String editMenuForm(Model model, @PathVariable Long id) {
        Menu menu = this.menuService.findById(id).orElseThrow();
        model.addAttribute("menu", menu);
        return "menu-form";
    }

    @PostMapping("/{id}/edit")
    public String editMenu(MenuRequestDto dto, @PathVariable Long id) {
        this.menuService.update(id, dto.getName(), dto.getPrice(), dto.getCategory());
        return "redirect:/menus";
    }
}
