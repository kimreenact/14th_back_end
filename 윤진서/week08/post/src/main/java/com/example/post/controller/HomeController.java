package com.example.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 홈 화면 컨트롤러.
 * REST API 와 별개로, Thymeleaf 템플릿(index.html)을 렌더링하여 API 안내 페이지를 보여준다.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("appName", "게시글 관리 API");
        model.addAttribute("swaggerUrl", "/swagger-ui.html");
        return "index"; // templates/index.html
    }
}
