package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getAll(@AuthenticationPrincipal User user,
                         ModelMap model) {
        model.addAttribute("user", user);
        model.addAttribute("autos", autoService.getAll());
        return "autos/list";
    }

    @GetMapping("/{id}")
    public String getOne(@AuthenticationPrincipal User user,
                         @PathVariable Long id, ModelMap model) {
        model.addAttribute("auto", autoService.getOne(id));
        model.addAttribute("user", user);
        return "autos/card";
    }

}
