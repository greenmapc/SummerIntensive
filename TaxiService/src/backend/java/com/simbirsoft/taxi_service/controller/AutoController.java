package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;

@RequestMapping("/autos")
@Controller
@RequiredArgsConstructor
public class AutoController {
    private final AutoService autoService;


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
        try {
            model.addAttribute("auto", autoService.findOneById(id));
        } catch (EntityNotFoundException e) {
            // ToDo: handle not found
        }
        model.addAttribute("user", user);
        return "autos/card";
    }

    @GetMapping("/a")
    public String getPage(@AuthenticationPrincipal User user,
                          @RequestParam(value = "filter", required = false) String[] conditionItems,
                          @RequestParam(value = "page", required = false) Integer pageNumber,
                          ModelMap model) {
        model.addAttribute("autos", autoService.getPage(pageNumber, conditionItems));
        return "testRustemSorry/autos";
    }

    @GetMapping
    public String search(@AuthenticationPrincipal User user,
                         @RequestParam(value = "search") String searchString,
                         ModelMap model) {
        model.addAttribute("autos",autoService.search(searchString));
        return "autos/search";
    }
}
