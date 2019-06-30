package com.carrental.controller;

import com.carrental.common.dto.UserDto;
import com.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("user", new UserDto());
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

}