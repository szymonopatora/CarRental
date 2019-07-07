package com.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {
    @GetMapping("/list")
    public String carList(Model model, @RequestParam(name="Start") String  start){
        // get cars list
        // put cars list in thymeleaf context
        model.addAttribute("start", start);
        return "list";
    }
}
