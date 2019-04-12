package com.example.exmpl1.presentation.controller;

import com.example.exmpl1.presentation.forms.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private static final String REGISTRATION_VIEW = "registration";

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String showRegistrationForm(@ModelAttribute("registrationForm")RegistrationForm form, ModelMap modelMap){
        return REGISTRATION_VIEW;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String submitRegistrationForm(@Valid @ModelAttribute("registrationForm")RegistrationForm form, BindingResult bindingResult, ModelMap modelMap){
        System.out.println("POsted!");
        System.out.println(form);
        return REGISTRATION_VIEW;
    }

}
