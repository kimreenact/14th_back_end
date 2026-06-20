/*
생성자 주입으로 MenuService 주입
아래 URL 매핑 구현
/menus GET 전체 메뉴 목록
/menus/{id} GET 메뉴 상세 조회
/menus/new GET 메뉴 등록 폼
/menus/new POST 메뉴 등록 처리
/menus/{id}/edit GET 메뉴 수정 폼
/menus/{id}/edit POST 메뉴 수정 처리
 */


package com.example.cafe.controller;

import com.example.cafe.dto.MenuRequestDto;
import com.example.cafe.model.Menu;
import com.example.cafe.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    //전체 메뉴 조회
    @GetMapping("/menus")
    public String menuList(Model model) {
        model.addAttribute("menus", menuService.findAll());
        return "menu-list";
    }
    //메뉴 상세 조회
    @GetMapping("/menus/{id}")
    public String menuDetail(@PathVariable Long id, Model model){
        Menu menu = menuService.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다."));
        model.addAttribute("menu", menu);

        return "menu-detail";
    }
    //메뉴 등록 폼
    @GetMapping("/menus/new")
    public String menuForm() {
        return "menu-form";
    }
    //메뉴 등록 처리
    @PostMapping( "/menus/new")
    public String saveMenu(@ModelAttribute MenuRequestDto requestDto) {
        menuService.save(requestDto);
        return "redirect:/menus";
    }
    //메뉴 수정 폼
    @GetMapping("/menus/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Menu menu = menuService.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다."));
        model.addAttribute("menu", menu);
        return "menu-form";
    }
    //메뉴 수정 처리
    @PostMapping("/menus/{id}/edit")
    public String editMenu(@PathVariable Long id,
                           @ModelAttribute MenuRequestDto requestDto) {
        menuService.update(id, requestDto.getName(), requestDto.getPrice(), requestDto.getCategory());
        return "redirect:/menus/" + id;
    }

}

