package com.amdocs.adminservice.controller;

import com.amdocs.adminservice.entity.User;
import com.amdocs.adminservice.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
public class ViewController {

    private final UserServiceImpl userService;

    public ViewController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "home";
    }

    @GetMapping("/new-user")
    public String getAllUsers(Model model, User user) {
        model.addAttribute("users", userService.saveUser(user));
        return "add-users";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.getUserByid(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setUser_id(id);
            return "update-user";
        }

        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.getUserByid(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/addusers")
    public String saveUser(@Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-user";
        }

        userService.saveUser(user);
        return "redirect:/";
    }
}
