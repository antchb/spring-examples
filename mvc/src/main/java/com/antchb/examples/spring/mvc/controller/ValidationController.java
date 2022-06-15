package com.antchb.examples.spring.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antchb.examples.spring.mvc.model.Customer;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    @RequestMapping("/input")
    public String getForm(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "validation/form";
    }

    // BindingResult parameter must be right after @ModelAttribute
    @RequestMapping("/process")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult) {
        System.out.println(customer);

        return bindingResult.hasErrors() ? "validation/form" : "validation/result";
    }

    // It works as a pre-processor. It pre-process each web-request to our controller
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        // Pre-process every String form data. If it has only white space then convert to null
        // All leading and trailing spaces will be removed as well
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
