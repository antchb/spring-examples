package com.antchb.examples.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antchb.examples.spring.mvc.model.User;

@Controller
@RequestMapping("/mvc-form-tags")
public class MvcFormTagsController {

    @RequestMapping("/input")
    public String getForm(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "mvc-form-tags/form";
    }

    @RequestMapping("/process")
    public String processForm(@ModelAttribute("user") User user) {
        System.out.println(user);

        return "mvc-form-tags/result"; 
    }
}
