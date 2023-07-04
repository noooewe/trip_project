package com.portfolio.trip_project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        return "Admin";
    }
}
