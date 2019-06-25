package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.util.freemaker_select_creator.CreateAutoSelectCreator;
import com.simbirsoft.taxi_service.util.validator.AutoFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/autos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AutoController {
    private final AutoService autoService;

    @InitBinder("form")
    public void initAutoFormBinder(WebDataBinder binder) {
        binder.addValidators(new AutoFormValidator());
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
        try {
            model.addAttribute("auto", autoService.findOneById(id));
        } catch (EntityNotFoundException e) {
            // ToDo: handle not found
        }
        model.addAttribute("user", user);
        return "autos/card";
    }

    @GetMapping("/{id}/update")
    public String updatePage(@PathVariable Long id,
                             Model model) {
        model.addAttribute("bodyType", CreateAutoSelectCreator.bodyTypeCreate());
        model.addAttribute("driveType", CreateAutoSelectCreator.driveTypeCreate());
        model.addAttribute("transmissionType", CreateAutoSelectCreator.transmissionType());
        Auto auto = autoService.findOneById(id);
        model.addAttribute("auto", auto);
        model.addAttribute("form", AutoForm.createFromAuto(auto));
        return "autos/update";
    }

    @PostMapping("/{id}/update")
    public String updateAuto(@PathVariable Long id,
                             @Validated @ModelAttribute("form") AutoForm form,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("auto", autoService.findOneById(id));
            return "autos/update";
        }
        autoService.updateInfo(autoService.findOneById(id), form);
        return "redirect:/autos/" + id;
    }
}
