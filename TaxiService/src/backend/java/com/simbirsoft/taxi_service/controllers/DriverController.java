package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/drivers")
@Controller
public class DriverController {
    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public String getAll(ModelMap model) {
        model.addAttribute("drivers", driverService.getAll());
        return "drivers/list";
    }
    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id, ModelMap model) {
        try {
            model.addAttribute("driver",driverService.getOne(id));
        } catch (IllegalArgumentException ex) {
            return "error/404";
        }
        return "drivers/card";
    }
}
