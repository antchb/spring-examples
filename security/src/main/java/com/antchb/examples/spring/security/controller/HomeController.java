package com.antchb.examples.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String displayHomePage() {
        return "home";
    }

    @GetMapping("/admin")
    public String displayAdminPage() {
        return "admin";
    }
}
