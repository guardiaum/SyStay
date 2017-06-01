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
//    /* It provides list of employees in model object */  
//    @RequestMapping("/viewhospede")  
//    public ModelAndView viewhospede(){  
//        List<Hospede> list=dao.getEmployees();  
//        return new ModelAndView("viewemp","list",list);  
//    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
//    @RequestMapping(value="/edithospede/{numeroDocumento}")  
//    public ModelAndView edit(@PathVariable String numeroDocumento){  
//        Hospede hospede=dao.getEmpById(numeroDocumento);  
//        return new ModelAndView("hospedempeditform","command",hospede);  
//    }  
//    /* It updates model object. */  
//    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
//    public ModelAndView editsave(@ModelAttribute("hospede") Hospede hospede){  
//        dao.update(hospede);  
//        return new ModelAndView("redirect:/viewhospede");  
//    }  
//    /* It deletes record for the given id in URL and redirects to /viewemp */  
//    @RequestMapping(value="/deletehospede/{numeroDocumento}",method = RequestMethod.GET)  
//    public ModelAndView delete(@PathVariable String numeroDocumento){  
//        dao.delete(numeroDocumento);  
//        return new ModelAndView("redirect:/viewhospede");  
//    }  
  
}