package com.github.Carlos_cj0.LawArticleGenerationWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String showMainPage(Model model) {
        return "main"; // No need for .html, Thymeleaf auto-detects it in templates/
    }
}