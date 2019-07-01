package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.exception.NotFoundException;
import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.DriverService;
import com.simbirsoft.taxi_service.util.validator.DriverFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;

@RequestMapping("/drivers")
@Controller
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;
    private final DriverFormValidator driverFormValidator;

    @InitBinder("driverForm")
    public void initDriverFormBinder(WebDataBinder binder) {
        binder.addValidators(driverFormValidator);
    }



    @GetMapping("/{id}")
    public String getOne(@AuthenticationPrincipal User user,
                         @PathVariable Long id, Model model) {
        try {
            model.addAttribute("driver", driverService.findOneById(id));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException();
        }
        model.addAttribute("user", user);
        return "drivers/card";
    }

    @GetMapping
    public String getPage(@AuthenticationPrincipal User user,
                          @RequestParam(value = "filter", required = false) String[] conditionItems,
                          @RequestParam(value = "page", required = false) Integer pageNumber,
                          ModelMap model) {
        Page<Driver> page =driverService.getPage(pageNumber, conditionItems);
        model.addAttribute("drivers", page.getContent());
        model.addAttribute("user",user);
        model.addAttribute("pageNumber",page.getNumber()+1);
        model.addAttribute("lastPageNumber",page.getTotalPages());
        if(conditionItems != null && Arrays.asList(conditionItems).contains("banned")) {
            model.addAttribute("banned", true);
        }

        return "drivers/list";
    }
    @GetMapping("/search")
    public String search(@AuthenticationPrincipal User user,
                         @RequestParam(value = "search") String searchString,
                         ModelMap model) {
        model.addAttribute("drivers",driverService.search(searchString));
        model.addAttribute("user",user);
        return "drivers/search";
    }

    @GetMapping("/{id}/update")
    public String updateDriverPage(@PathVariable Long id,
                                   Model model) {
        Driver driver = driverService.findOneById(id);
        model.addAttribute("driver", driver);
        model.addAttribute("driverForm", DriverForm.createFromDriver(driver));
        return "drivers/update";
    }

    @PostMapping("/{id}/update")
    public String updateDriver(@PathVariable Long id,
                               @Validated @ModelAttribute("driverForm") DriverForm form,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("driver", driverService.findOneById(id));
            return "drivers/update";
        }
        driverService.updateInfo(driverService.findOneById(id), form);
        return "redirect:/drivers/" + id;
    }
}
