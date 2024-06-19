package com.example.LT_Java_Giuaky_2180602594.controller;

import com.example.LT_Java_Giuaky_2180602594.entity.Nhanvien;
import com.example.LT_Java_Giuaky_2180602594.services.NhanvienService;
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
@RequestMapping("/nhanviens")

public class NhanvienController {
    @Autowired
    private final NhanvienService nhanvienService;

    @Autowired
    private final PhongbanService phongbanService;


    @GetMapping
    public String showAllNhanviens(Model model){
        List<Nhanvien> nhanviens = nhanvienService.getAllNhanviens();
        model.addAttribute("nhanviens", nhanviens);
        return "nhanvien/list";
    }

   /* @GetMapping("/")
    public String home(){ return "home/index";}*/

    @GetMapping("/add")
    public String addNhanvienForm(Model model) {
        model.addAttribute("nhanvien",new Nhanvien());
        model.addAttribute("phongbans",phongbanService.getAllPhongbans());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanvien(@Valid @ModelAttribute("nhanvien") Nhanvien nhanvien, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("phongbans",phongbanService.getAllPhongbans());
            return "nhanvien/add";
        }
        nhanvienService.addNhanvien(nhanvien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanvien(@PathVariable("id") Long id) {
        nhanvienService.deleteNhanvien(id);
        return "redirect:/nhanviens";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Nhanvien nhanvien = nhanvienService.getNhanvienById(id);
        model.addAttribute("nhanvien", nhanvien);
        model.addAttribute("phongbans", phongbanService.getAllPhongbans());
        return "/nhanvien/edit";
    }

    //test
    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid Nhanvien nhanvien,
                             BindingResult result) {
        if (result.hasErrors()) {
            nhanvien.setId(id);
            return "/nhanvien/edit";
        }
        nhanvienService.updateNhanvien(nhanvien);
        return "redirect:/nhanviens";
    }
}