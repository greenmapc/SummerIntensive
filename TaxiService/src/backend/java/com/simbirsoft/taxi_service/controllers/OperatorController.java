package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.forms.AutoForm;
import com.simbirsoft.taxi_service.forms.DriverForm;
import com.simbirsoft.taxi_service.validators.AutoFormValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operator")
public class OperatorController {

    @GetMapping("/create_auto")
    public String createAutoPage(Model model) {
        model.addAttribute("form", new AutoForm());
        return "operator/create_auto";
    }

    @PostMapping("/create_auto")
    public String createAuto(@Validated @ModelAttribute("form") AutoForm form,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            /*Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("form", form);*/
//            model.addAttribute("form", form);
            return "operator/create_auto";
        }
        return "redirect:/autos";
    }

    @GetMapping("/create_driver")
    public String createDriverPage(Model model) {
        model.addAttribute("form", new DriverForm());
        return "operator/create_driver";
    }

    @PostMapping("/create_driver")
    public String createDriver(@ModelAttribute("form") AutoForm form,
                               Model model,
                               BindingResult bindingResult) {

        return "redirect:/drivers";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new AutoFormValidator());
    }
}
