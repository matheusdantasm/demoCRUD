package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // Redireciona a raiz "/" para /cadastro
    @GetMapping("/")
    public String home() {
        return "redirect:/cadastro";
    }

    // Página de cadastro
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro"; // busca cadastro.html no templates
    }

}