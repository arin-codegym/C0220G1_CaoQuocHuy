package com.codegym.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
//@SessionAttributes("userInfo")
public class LoginController {

    @GetMapping("/")
    public String goLogin(Model model,
                          @CookieValue(value = "userInfoUsername", defaultValue = "") String userInfoUsername,
                          @CookieValue(value = "userInfoPassword", defaultValue = "") String userInfoPassword) {
//        // session
//        model.addAttribute("userInfo", new User());

        // cookie
        model.addAttribute("userInfoUsername", userInfoUsername);
        model.addAttribute("userInfoPassword", userInfoPassword);

        return "login";
    }

    @GetMapping("/checkLogin")
    public String checkLogin(HttpServletRequest request, HttpServletResponse response, Principal principal  ) {

        User user = (User) ((Authentication) principal).getPrincipal();

        // service -> true
        Cookie cookieUsername = new Cookie("userInfoUsername", user.getUsername());
        Cookie cookiePassword = new Cookie("userInfoPassword", user.getPassword());
//        cookie.setMaxAge(10);
        response.addCookie(cookieUsername);
        response.addCookie(cookiePassword);

      request.getSession().setAttribute("userInfo", user);

        return "redirect:/list";
    }

    @GetMapping("/403")
    public String authorFail() {
        return "403";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/";
    }
}
