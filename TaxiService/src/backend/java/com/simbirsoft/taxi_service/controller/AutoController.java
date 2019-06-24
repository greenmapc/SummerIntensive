package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.filters.Condition;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Stream;

@RequestMapping("/autos")
@Controller
@RequiredArgsConstructor
public class AutoController {
    private final AutoService autoService;
    private final ConditionService conditionService;

    @GetMapping
    public String getAll(@AuthenticationPrincipal User user,
                         @RequestParam("f") List<String> conditionItems,
                         ModelMap model) {
        model.addAttribute("user", user);
        model.addAttribute("autos", autoService.getAll());
        List<Condition> conditions = conditionService.getConditionsWithoutOperation(conditionItems);
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

}
