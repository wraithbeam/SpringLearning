package com.wraithbeam.firstApp.controllers;

import com.wraithbeam.firstApp.models.Flat;
import com.wraithbeam.firstApp.repositorys.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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

    @GetMapping("/add")
    public String addpage(Model model) {
        return "addpage";
    }

    @PostMapping("/add")
    public String addpagePost(@RequestParam String title,
                              @RequestParam String address,
                              @RequestParam String addressShort,
                              @RequestParam double square,
                              @RequestParam int rooms,
                              @RequestParam int cost,
                              @RequestParam int floor,
                              @RequestParam int floorsInBuilding,
                              @RequestParam String imageLink,
                              Model model){
        Flat flat = new Flat(title, address, addressShort, square, rooms, cost, floor, floorsInBuilding, imageLink);
        flatRepository.save(flat);
        return "redirect:/";
    }

    @GetMapping("/flat/{id}")
    public String flatDetails(@PathVariable(value = "id") long id, Model model) {
        Optional<Flat> optionalFlat = flatRepository.findById(id);
        Flat flat = optionalFlat.get();
        model.addAttribute("flat", flat);
        return "flatDetails";
    }
}
