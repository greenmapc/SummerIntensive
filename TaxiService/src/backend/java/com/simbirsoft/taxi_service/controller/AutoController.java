package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.dto.AutoSelectDto;
import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.util.select.AutoSelectCreator;
import com.simbirsoft.taxi_service.util.validator.AutoFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
@RequiredArgsConstructor
@RequestMapping("/autos")
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
        model.addAttribute("autos", autoService.search(searchString));
        return "autos/search";
    }

    @GetMapping("/{id}/update")
    public String updatePage(@PathVariable Long id,
                             Model model) {
        model.addAttribute("bodyType", AutoSelectCreator.bodyTypeCreate());
        model.addAttribute("driveType", AutoSelectCreator.driveTypeCreate());
        model.addAttribute("transmissionType", AutoSelectCreator.transmissionType());
        Auto auto = autoService.findOneById(id);
        model.addAttribute("auto", auto);
        model.addAttribute("form", AutoForm.createFromAuto(auto));
        return "autos/update";
    }

    @PostMapping("/{id}/update")
    public String updateAuto (@PathVariable Long id,
                              @Validated @ModelAttribute("form") AutoForm form,
                              BindingResult bindingResult,
                              Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("auto", autoService.findOneById(id));
            return "autos/update";
        }
        autoService.updateInfo(autoService.findOneById(id), form);
        return "redirect:/autos/" + id;
    }

    @GetMapping(value = "/getRentedAuto", produces = "application/json")
    @ResponseBody
    public AutoSelectDto getAutoFromUser (@RequestParam("id") Long id){
        AutoSelectDto dto = new AutoSelectDto();
        dto = dto.createByAuto(autoService.findAllRentedByUser(id));
        return dto;
    }
}
