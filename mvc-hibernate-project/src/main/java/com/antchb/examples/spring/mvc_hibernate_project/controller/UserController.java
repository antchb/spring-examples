package com.antchb.examples.spring.mvc_hibernate_project.controller;

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

import com.antchb.examples.spring.mvc_hibernate_project.entity.User;
import com.antchb.examples.spring.mvc_hibernate_project.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();

        model.addAttribute("users", users);

        return "users-list";
    }

    @GetMapping("/add-form")
    public String displayAddUserForm(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getUserId() != null) {
            userService.updateUser(user.getUserId(), user);
        } else {
            userService.addUser(user);
        }

        return "redirect:/user/list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long userId) {
        userService.deleteUser(userId);

        return "redirect:/user/list";
    }

    @GetMapping("/update-form")
    public String displayUpdateUserForm(@RequestParam("userId") Long userId, Model model) {
        Optional<User> user = userService.getUser(userId);
        model.addAttribute("user", user.get());

        return "user-form";
    }
}
