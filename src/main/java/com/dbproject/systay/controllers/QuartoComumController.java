/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.controllers;

import com.dbproject.systay.beans.QuartoComum;
import com.dbproject.systay.services.interfaces.QuartoComumService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author araujomarianna
 */
@Controller
public class QuartoComumController {
    
    @Autowired
    public QuartoComumService quartoComumService;
    
    @RequestMapping("/cadastrarquartocomum")  
    public ModelAndView showform(){  
        return new ModelAndView("cadastrarquartocomum","command",new QuartoComum());  
    } 
    
    @RequestMapping(value="/salvarquartocomum",method = RequestMethod.POST)  
    public ModelAndView cadastrar(@ModelAttribute("QuartoComum") QuartoComum quartocomum){
        quartoComumService.cadastrar(quartocomum);
        return new ModelAndView("redirect:/listarquartocomum");
    }
    
    @RequestMapping("/listarquartocomum")  
    public ModelAndView listarquartocomum(){  
        List<QuartoComum> list = quartoComumService.getQuartosComuns();  
        return new ModelAndView("listarquartocomum","list",list);  
    }  
    
    @RequestMapping(value="/editarquartocomum/{id}")  
    public ModelAndView editarquartocomum(@PathVariable int id){
        QuartoComum qc = quartoComumService.getQuartoComum(id);
        return new ModelAndView("editarquartocomum","command",qc);  
    }

     /* It updates model object. */ 
    @RequestMapping(value="/editsavequartocomum",method = RequestMethod.POST)  
    public ModelAndView editsavequartocomum(@ModelAttribute(value="quartocomum") QuartoComum quartocomum){ 
        quartoComumService.atualizarQuartoComum(quartocomum);
        return new ModelAndView("redirect:/listarquartocomum");  
    }
    
    @RequestMapping(value="/deletarquartocomum/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){
        quartoComumService.deletarQuartoComum(id);  
        return new ModelAndView("redirect:/listarquartocomum"); 
    }  
    
    @RequestMapping(value = "/exibirquartocomum/{id}",method = RequestMethod.GET)  
    public ModelAndView exibirquartocomum(@PathVariable int id) {
        QuartoComum quartocomum = quartoComumService.getQuartoComum(id);
        return new ModelAndView("viewquartocomum", "quartocomum", quartocomum);  
    }

    
}
