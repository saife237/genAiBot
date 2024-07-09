package com.example.genAiBot.controller;


import org.springframework.web.bind.annotation.GetMapping;


public class ChatbotController {
    

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/upload")
    public String uploadForm() {
        return "upload";
    }

  
}
