package com.example.cafe.controller;

import com.example.cafe.model.Menu;
import com.example.cafe.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/menus")
    public String getMenuList (Model model) {
        List<Menu> menus = menuService.findAll();
        model.addAttribute("menus", menus);
        return "menu-list";
    }

    @GetMapping("/menus/{id}")
    public String getMenuDetail (@PathVariable Long id, Model model){
        Optional<Menu> menu =menuService.findById(id);
        model.addAttribute("menu", menu.get());
        return "menu-detail";
    }

    @GetMapping("/menus/new")
    public String newMenu (Model model){
        return "menu-form";
    }

    @PostMapping("/menus/new")
    public String MenuUpdate (@RequestParam String name,
                              @RequestParam int price,
                              @RequestParam String category
                              ){
        menuService.save(name,price,category);
        return "redirect:/menus";
    }

    @GetMapping("/menus/{id}/edit")
    public String editMenu (@PathVariable Long id,Model model){
        Optional<Menu> menu =menuService.findById(id);
        model.addAttribute("menu", menu.get());
        return "menu-form";
    }

    @PostMapping("/menus/{id}/edit")
    public String editMenuUpdate (@PathVariable Long id,
                                  @RequestParam String name,
                                  @RequestParam int price,
                                  @RequestParam String category
    ){
        menuService.update(id,name,price,category);
        return "redirect:/menus";
    }

}
