package com.example.cafe.controller;

import com.example.cafe.dto.MenuRequestDto;
import com.example.cafe.model.Menu;
import com.example.cafe.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
//URL 보다가 요청 가장 먼저 받는 거
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;
    //Service..  의존성(생성자)주입

    //전체 메뉴 목록
    @GetMapping("/menus")
    //Get요청처리
    public String menuList(Model model) {

        model.addAttribute("menus", menuService.findAll());
        return "menu-list";
        //Controller에서 view로 데이터 전달. menu-list.html에서 menus 사용가능하게

    }

    //메뉴 상세 조회
    @GetMapping("/menus/{id}")

    public String menuDetail(@PathVariable Long id, Model model) {
    //PathVariable -> URL 값 가져오기

        Optional<Menu> optionalMenu = menuService.findById(id);
        //없는 메뉴는 접근 방지하게 하기

        if (optionalMenu.isEmpty()) {

            return "redirect:/menus";
            //새로 고침하면 중복저장 방지

        }

        model.addAttribute("menu", optionalMenu.get());

        return "menu-detail";
    }

    //메뉴 등록
    @GetMapping("/menus/new")
    public String menuForm() {
        return "menu-form";
    }

    // 메뉴 등록 처리
    @PostMapping("/menus/new")
    public String createMenu(MenuRequestDto dto) {

        menuService.save(dto);

        return "redirect:/menus";
    }

    //메뉴 수정 요청
    @GetMapping("/menus/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {

        Optional<Menu> optionalMenu = menuService.findById(id);

        if (optionalMenu.isEmpty()) {
            return "redirect:/menus";
        }

        model.addAttribute("menu", optionalMenu.get());
        //기존 값이 담긴 수정된 메뉴 출력



        return "menu-form";
    }

    //메뉴 수정 요청 처리하기
    @PostMapping("/menus/{id}/edit")
    public String editMenu(@PathVariable Long id,
                           MenuRequestDto dto) {

        menuService.update(id, dto);

        return "redirect:/menus/" + id;
        //수정 후 상세페이지로 이동
    }
}

