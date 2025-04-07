package com.github.Carlos_cj0.LawArticleGenerationWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // to tell Spring to render login.html
    }
}