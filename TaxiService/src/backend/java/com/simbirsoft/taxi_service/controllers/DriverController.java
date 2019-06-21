package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.models.User;
import com.simbirsoft.taxi_service.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;

@RequestMapping("/drivers")
@Controller
public class DriverController {
    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public String getAll(@AuthenticationPrincipal User user,
                         ModelMap model) {
        model.addAttribute("drivers", driverService.getAll());
        model.addAttribute("user", user);

        return "drivers/list";

    }

    @GetMapping("/{id}")
    public String getOne(@AuthenticationPrincipal User user,
                         @PathVariable Long id, ModelMap model) {
        model.addAttribute("user", user);
        model.addAttribute("driver", driverService.getOne(id));
        return "drivers/card";
    }
}
