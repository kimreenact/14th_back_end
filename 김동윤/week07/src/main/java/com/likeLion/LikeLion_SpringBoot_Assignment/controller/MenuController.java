package com.likeLion.LikeLion_SpringBoot_Assignment.controller;

import com.likeLion.LikeLion_SpringBoot_Assignment.dto.MenuRequestDto;
import com.likeLion.LikeLion_SpringBoot_Assignment.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public String getMenu(Model model){
        model.addAttribute("menus",menuService.getAllMenus());
        return "menu-list";
    }

    @GetMapping("/{id}")
    public String detailMenu(@PathVariable Long id, Model model){
        menuService.getMenu(id)
                .ifPresent(m -> model.addAttribute("menu", m)); // 꺼내서 넣음
        return  "menu-detail";
    }

    @GetMapping("/new")
    public String newMenuForm(){
        return  "menu-form";
    }

    @PostMapping("/new")
    public String createMenu(MenuRequestDto menuRequestDto){
        menuService.register(menuRequestDto);
        return "redirect:/menus";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Optional menu = menuService.getMenu(id);

        if(menu.isEmpty()){
            return "redirect:/menus";
        }

        model.addAttribute("menu", menu.get());
        return "menu-form";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, MenuRequestDto menuRequestDto){
        menuService.updateMenu(id, menuRequestDto);
        return  "redirect:/menus/" + id;
    }


}
