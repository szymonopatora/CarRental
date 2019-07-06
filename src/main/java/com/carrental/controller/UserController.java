package com.carrental.controller;

import com.carrental.common.dto.UserDto;
import com.carrental.persistence.entity.User;
import com.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDto userDto,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registerForm";
        }
        userService.saveUser(userDto);
        return "redirect:/";
    }

//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("user", new UserDto());
//        return "loginForm";
//    }

    @PostMapping
    public String login(@ModelAttribute("user") @Valid User user) {
        if (user.getRole().equals(1L)) {
            return "administration";
        }
        return "loginForm";
    }

    @PutMapping("/addEmployee/{id}")
    public void addEmployee(@PathVariable Long id) {
        userService.addEmployee(id);
    }

    @PutMapping("/addManager/{id}")
    public void addManager(@PathVariable Long id) {
        userService.addManager(id);
    }
}