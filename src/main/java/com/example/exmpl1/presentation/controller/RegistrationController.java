package com.example.exmpl1.presentation.controller;

import com.example.exmpl1.dao.UserDAO;
import com.example.exmpl1.entity.User;
import com.example.exmpl1.presentation.forms.RegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.concurrent.Semaphore;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private Semaphore mutex = new Semaphore(1);
    private static Logger LOG  = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    private UserDAO userDAO;

    private static final String REGISTRATION_VIEW = "registration";

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String showRegistrationForm(@ModelAttribute("registrationForm")RegistrationForm form, ModelMap modelMap) throws InterruptedException {
//        User u = userDAO.save(form.toUser());
//        u.setFirstName("ok name");
//        u.setPostalCode("2342");
//        userDAO.save(u);
//        LOG.debug(String.format("Number of threads queued: %d. Number of available permits: %d",mutex.getQueueLength(),mutex.availablePermits()));
//        mutex.acquire();
//        LOG.debug("Doing the work on: " + Thread.currentThread());
//        mutex.release();
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
