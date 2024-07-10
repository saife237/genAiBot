package com.example.genAiBot.controller;


import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.genAiBot.util.PDFUtil;


public class ChatbotController {
    

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/upload")
    public String uploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadResume(@RequestParam("file") MultipartFile file, Model model) {
        try{
            String resumeText = PDFUtil.extractText(file);
            model.addAttribute("resumeText",resumeText);
            return "chat";
        } catch (IOException e) {
            model.addAttribute("message", "Failed to read the PDF file");
            return "upload";
        }
    }
  
}
