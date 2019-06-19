package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
}
