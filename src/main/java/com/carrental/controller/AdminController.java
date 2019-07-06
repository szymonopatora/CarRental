package com.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/administration")
    public String getAdminPage() {
        return "administration";
    }


}
