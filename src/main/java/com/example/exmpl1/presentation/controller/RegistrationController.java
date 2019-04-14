package com.example.exmpl1.presentation.controller;

import com.example.exmpl1.dao.UserDAO;
import com.example.exmpl1.entity.User;
import com.example.exmpl1.presentation.forms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserDAO userDAO;

    private static final String REGISTRATION_VIEW = "registration";

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String showRegistrationForm(@ModelAttribute("registrationForm")RegistrationForm form, ModelMap modelMap){
        User u = userDAO.save(form.toUser());
        u.setFirstName("ok name");
        u.setPostalCode("2342");
        userDAO.save(u);
        return REGISTRATION_VIEW;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String submitRegistrationForm(@Valid @ModelAttribute("registrationForm")RegistrationForm form, BindingResult bindingResult, ModelMap modelMap){
        System.out.println("POsted!");
        System.out.println(form);
        if (bindingResult.hasErrors()){
            return REGISTRATION_VIEW;
        }
        User u = userDAO.save(form.toUser());

        if (u != null) modelMap.addAttribute("successMessage","User created with ID " + u.getId());
        return REGISTRATION_VIEW;
    }

}
