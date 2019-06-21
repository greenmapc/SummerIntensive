package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.DriverService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DriverController {
    private final DriverService driverService;

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
        try {
            model.addAttribute("driver", driverService.findOneById(id));
        } catch (EntityNotFoundException e) {
            // ToDo: handle not found
        }
        model.addAttribute("user", user);

        return "drivers/card";
    }
}
