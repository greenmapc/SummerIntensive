package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.filters.Condition;
import com.simbirsoft.taxi_service.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequestMapping("/drivers")
@Controller
@RequiredArgsConstructor
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

    @GetMapping("/a")
    public String getPage(@AuthenticationPrincipal User user,
                          @RequestParam(value = "filter", required = false) String[] conditionItems,
                          @RequestParam(value = "page", required = false) Integer pageNumber,
                          ModelMap model) {
        model.addAttribute("drivers", driverService.getPage(pageNumber, conditionItems));
        return "testRustemSorry/drivers";
    }
    @GetMapping
    public String search(@AuthenticationPrincipal User user,
                         @RequestParam(value = "search") String searchString,
                         ModelMap model) {
        model.addAttribute("drivers",driverService.search(searchString));
        return "drivers/search";
    }

    

}
