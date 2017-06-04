/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.controllers;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Hospede;
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
        administrador = adminService.cadastrar(administrador);
        ModelAndView mv = new ModelAndView("viewadmin");
        mv.addObject("admin", administrador);
        return mv;
    }  
    
    /* It provides list of employees in model object */  
    @RequestMapping(value="/listaradmins",method = RequestMethod.GET)
    public ModelAndView viewAdmins(){  
        List<Administrador> list = adminService.getAdministradores();  
        return new ModelAndView("listaradmins","list",list);  
    }  
    
    @RequestMapping(value="/editaradmin/{numeroDocumento}")  
    public ModelAndView editaradmin(@PathVariable String numeroDocumento){  
        Administrador admin =adminService.getAdministradorById(numeroDocumento);  
        return new ModelAndView("editaradmin","command", admin);  
    }  
    
    /* It updates model object. */ 
    @RequestMapping(value="/editsaveadmin", method = RequestMethod.POST)  
    public ModelAndView atualizarAdmin(@ModelAttribute("administrador") Administrador administrador){  
        adminService.atualizarAdministrador(administrador);  
        return new ModelAndView("redirect:/listaradmins");  
    }
    
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deletaradmin/{numeroDocumento}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable String numeroDocumento){
        adminService.deletarAdministrador(numeroDocumento);  
        return new ModelAndView("redirect:/listaradmins"); 
    }  
    
    @RequestMapping(value = "/exibiradmin/{numeroDocumento}",method = RequestMethod.GET)  
    public ModelAndView exibirhospede(@PathVariable String numeroDocumento) {
        Administrador adm = adminService.getAdministradorById(numeroDocumento);
        return new ModelAndView("viewadmin", "admin", adm);  
    }
}
