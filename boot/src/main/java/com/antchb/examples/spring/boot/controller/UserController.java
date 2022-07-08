package com.antchb.examples.spring.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.antchb.examples.spring.boot.entity.User;
import com.antchb.examples.spring.boot.exception.UserNotFoundException;
import com.antchb.examples.spring.boot.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/main")
    public String mainPage(Model model) {
        List<User> users = userService.getAll();

        model.addAttribute("users", users);

        return "users-main";
    }

    @GetMapping("/add-form")
    public String addPage(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "user-form";
    }

    @GetMapping("/update-form")
    public String updatePage(@RequestParam("id") Long id, Model model) {
        Optional<User> user = userService.get(id);
        
        if (!user.isPresent()) {
            throw new UserNotFoundException(id);
        }

        model.addAttribute("user", user);

        return "user-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/users/main";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);

        return "redirect:/users/main";
    }

}
