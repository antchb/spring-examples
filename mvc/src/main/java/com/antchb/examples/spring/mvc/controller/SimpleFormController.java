package com.antchb.examples.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/simple-form")
public class SimpleFormController {
    
    @RequestMapping("/input")
    public String getForm() {
        return "/simple-html-form/form";
    }

    @RequestMapping("/process")
    public String process() {
        return "/simple-html-form/result";
    }

    @RequestMapping("/process-uppercase")
    public String processToUpperCase(HttpServletRequest request, Model model) {
        String userName = request.getParameter("user_name");
        
        model.addAttribute("model_uppercase_result", userName.toUpperCase());

        return "/simple-html-form/result";
    }

    @RequestMapping("/process-uppercase-v2")
    public String processToUpperCase(@RequestParam("user_name") String userName, Model model) {
        model.addAttribute("model_uppercase_result_v2", userName.toUpperCase());

        return "/simple-html-form/result";
    }
}
