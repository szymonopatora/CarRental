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


    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDto userDto,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registerForm";
        }
        userService.saveUser(userDto);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new UserDto());
        return "/login";
    }
//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("user", new UserDto());
//        return "loginForm";
//    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") @Valid User user) {
        if (user.getRole().equals(1L)) {
            return "administration";
        }
        return "loginForm";
    }

    @GetMapping("/addRole")
    public String addRole() {
        return "addRole";
    }

    @PutMapping("/addRole/{id}/{id}")
    public void addEmployee(@PathVariable Long id, Long role_id) {
        userService.addRole(id, role_id);
    }

}