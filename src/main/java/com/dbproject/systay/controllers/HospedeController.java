/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.controllers;

import com.dbproject.systay.beans.Hospede;
import com.dbproject.systay.services.interfaces.HospedeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        hospedeservice.save(hospede);  
        return new ModelAndView("redirect:/listarhospedes");
    }  
 
    @RequestMapping("/listarhospedes")  
    public ModelAndView listarhospedes(){  
        List<Hospede> list=hospedeservice.getHospedes();  
        return new ModelAndView("listarhospedes","list",list);  
    }  
     
    @RequestMapping(value="/editarhospede/{numeroDocumento}")  
    public ModelAndView edit(@PathVariable String numeroDocumento){  
        Hospede hospede=hospedeservice.getHospedeById(numeroDocumento);  
        return new ModelAndView("editarhospede","command",hospede);  
    }  

    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("hospede") Hospede hospede){  
        hospedeservice.update(hospede);  
        return new ModelAndView("redirect:/listarhospedes");  
    }  

    @RequestMapping(value="/daletarhospede/{numeroDocumento}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable String numeroDocumento){  
        hospedeservice.delete(numeroDocumento);  
        return new ModelAndView("redirect:/listarhospedes");  
    }
    
    @RequestMapping(value = "/exibirhospede/{numeroDocumento}",method = RequestMethod.GET)  
    public ModelAndView exibirhospede(@PathVariable String numeroDocumento) {
        Hospede hospede = hospedeservice.getHospedeById(numeroDocumento);
        return new ModelAndView("viewhospede", "hospede", hospede);  
    }
  
}