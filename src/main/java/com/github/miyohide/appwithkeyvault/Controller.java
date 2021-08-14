package com.github.miyohide.appwithkeyvault;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!!");
        return "index";
    }
}
