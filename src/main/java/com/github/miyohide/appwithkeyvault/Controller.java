package com.github.miyohide.appwithkeyvault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!!");
        return "index";
    }

    @GetMapping("setCustomers")
    public String setCustomers() {
        customerService.insertCustomers();
        return "setCustomers";
    }
}
