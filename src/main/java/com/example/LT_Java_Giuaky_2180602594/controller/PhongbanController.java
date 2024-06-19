package com.example.LT_Java_Giuaky_2180602594.controller;


import com.example.LT_Java_Giuaky_2180602594.entity.Phongban;
import com.example.LT_Java_Giuaky_2180602594.services.PhongbanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/phongbans")

public class PhongbanController {
    @Autowired
    private final PhongbanService phongbanService;

    @GetMapping("/add")
    public String addPhongbanForm(Model model) {
        model.addAttribute("phongban", new Phongban());
        return "phongban/add";
    }

    @PostMapping("/add")
    public String addPhongban(@Valid Phongban phongban, BindingResult result) {
        if (result.hasErrors()) {
            return "phongban/add";
        }
        phongbanService.addPhongban(phongban);
        return "redirect:/phongbans";
    }

    // Hiển thị danh sách danh mục
    @GetMapping
    public String showAllPhongbans(Model model) {
        List<Phongban> phongbans = phongbanService.getAllPhongbans();
        model.addAttribute("phongbans", phongbans);
        return "phongban/list";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Phongban phongban = phongbanService.getPhongbanById(id);
        model.addAttribute("phongban", phongban);
        return "/phongban/edit";
    }

    // POST request to update category
    @PostMapping("/edit/{id}")
    public String updatePhongban(@PathVariable("id") Long id, @Valid Phongban phongban,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            phongban.setId(id);
            return "/phongban/edit";
        }
        phongbanService.updatePhongban(phongban);
        model.addAttribute("phongbans", phongbanService.getAllPhongbans());
        return "redirect:/phongbans";
    }


    @GetMapping("/delete/{id}")
    public String deletePhongban(@PathVariable("id") Long id) {
        phongbanService.deletePhongban(id);
        return "redirect:/phongbans";
    }
}