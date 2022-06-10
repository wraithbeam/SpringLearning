package com.wraithbeam.firstApp.controllers;

import com.wraithbeam.firstApp.models.Flat;
import com.wraithbeam.firstApp.repositorys.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainPageController {
    @Autowired
    private FlatRepository flatRepository;

    @GetMapping("/")
    public String mainpage(Model model) {
        Iterable<Flat> flats = flatRepository.findAll();
        model.addAttribute("flats", flats);
        return "mainpage";
    }
}
