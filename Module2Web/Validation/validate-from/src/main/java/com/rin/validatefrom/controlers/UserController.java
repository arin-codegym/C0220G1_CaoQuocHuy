package com.rin.validatefrom.controlers;

import com.rin.validatefrom.models.User;
import com.rin.validatefrom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView showCreateUser() {
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("user") User user
            , BindingResult bindingResult) {

        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("user/create");
            return modelAndView;
        }



        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("user/result", "user", user);

        return modelAndView;
    }



}
