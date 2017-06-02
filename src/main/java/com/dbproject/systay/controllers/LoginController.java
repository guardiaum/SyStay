/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.controllers;

import com.dbproject.systay.beans.Login;
import com.dbproject.systay.services.interfaces.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author johny
 */
@Controller
public class LoginController {

    @Autowired
    public LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute("login") Login login, Model model) {
        model.addAttribute("login", new Login());
        ModelAndView mav = null;
        Login confirm = loginService.validarUsuario(login);
        if (confirm != null) {
            mav = new ModelAndView("home");
            mav.addObject("username", confirm.getUsername());
        } else {
            mav = new ModelAndView("redirect:/login");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }
}
