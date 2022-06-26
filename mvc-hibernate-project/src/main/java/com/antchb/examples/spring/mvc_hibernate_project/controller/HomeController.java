package com.antchb.examples.spring.mvc_hibernate_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/404")
    public String errorPageNotFound() {
        return "errors/404";
    }
}
