package com.wraithbeam.firstApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainPageController {
    @GetMapping("/")
    public String mainpage(Model model) {
        model.addAttribute("text", "Привет всем, пупси!");
        return "mainpage";
    }
}
