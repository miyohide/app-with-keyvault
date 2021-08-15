package com.github.miyohide.appwithkeyvault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "へっぽこ顧客管理アプリ V2へようこそ");
        return "index";
    }

    @PostMapping("setCustomers")
    public String setCustomers() {
        customerService.insertCustomers();
        return "setCustomers";
    }

    @GetMapping("getCustomers")
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getCustomerList();
        model.addAttribute("customers", customers);
        return "getCustomers";
    }

}
