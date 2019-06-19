package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/autos")
@Controller
public class AutoController {
    private AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public String getAll(ModelMap model) {
        model.addAttribute("autos", autoService.getAll());
        return "allAutos";
    }
}