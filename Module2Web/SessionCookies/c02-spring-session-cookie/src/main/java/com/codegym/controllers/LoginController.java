package com.codegym.controllers;

import com.codegym.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("userInfo")
public class LoginController {

//    @ModelAttribute("userInfo")
//    public User setupUser() {
//        return new User();
//    }

    @GetMapping("/")
    public String goLogin(Model model,
                          @CookieValue(value = "userInfoUsername", defaultValue = "") String userInfoUsername,
                          @CookieValue(value = "userInfoPassword", defaultValue = "") String userInfoPassword) {
        // session
        model.addAttribute("userInfo", new User());

        // cookie
        model.addAttribute("userInfoUsername", userInfoUsername);
        model.addAttribute("userInfoPassword", userInfoPassword);

        return "login";
    }

    @PostMapping("/checkLogin")
    public String checkLogin(@ModelAttribute("userInfo") User user, HttpServletResponse response) {
        // service -> true
        Cookie cookieUsername = new Cookie("userInfoUsername", user.getUsername());
        Cookie cookiePassword = new Cookie("userInfoPassword", user.getPassword());
//        cookie.setMaxAge(10);
        response.addCookie(cookieUsername);
        response.addCookie(cookiePassword);

        return "redirect:/list";
    }
}
