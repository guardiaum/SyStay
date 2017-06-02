/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.controllers;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.services.interfaces.AdminService;
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
 * @author johny
 */
@Controller
public class AdminController {
    @Autowired
    public AdminService adminService;
    
    @RequestMapping("/cadastraradmin")  
    public ModelAndView showform(){  
        return new ModelAndView("cadastraradmin","command",new Administrador());  
    }  
     
    @RequestMapping(value="/salvaradministrador",method = RequestMethod.POST)  
    public ModelAndView cadastrar(@ModelAttribute("Administrador") Administrador administrador){  
        //System.out.println("Endereço: CEP-"+administrador.getEndereco().getCep()+
        //        " | No-"+administrador.getEndereco().getNumero());
        administrador = adminService.cadastrar(administrador);
        ModelAndView mv = new ModelAndView("viewadmin");
        mv.addObject("admin", administrador);
        return mv;
    }  
    
    /* It provides list of employees in model object */  
    @RequestMapping("/viewadmins")  
    public ModelAndView viewAdmins(){  
        List<Administrador> list = adminService.getAdministradores();  
        return new ModelAndView("viewemp","list",list);  
    }  
    
    /* It updates model object. */ 
    @RequestMapping(value="/atualizar",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("Administrador") Administrador administrador){  
        adminService.atualizarAdministrador(administrador);  
        return new ModelAndView("redirect:/viewhospede");  
    }
    
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deletaradmin/{numeroDocumento}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable String numeroDocumento){
        adminService.deletarAdministrador(numeroDocumento);  
        return new ModelAndView("redirect:/viewhospede"); 
    }  
}
