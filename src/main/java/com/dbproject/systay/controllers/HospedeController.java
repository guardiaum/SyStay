/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.controllers;

import com.dbproject.systay.beans.Hospede;
import com.dbproject.systay.services.interfaces.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Chaina
 */
@Controller
public class HospedeController {  
    
    @Autowired             
    public HospedeService hospedeservice;
    
    @RequestMapping("/cadastrarhospede")  
    public ModelAndView showform(){  
        return new ModelAndView("cadastrarhospede","command",new Hospede());  
    }  
     
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("hospede") Hospede hospede){  
         System.out.println("HospedeDaoImplfim");
        hospedeservice.save(hospede);  
        return new ModelAndView("redirect:/cadastrarhospede");
    }  

  
}