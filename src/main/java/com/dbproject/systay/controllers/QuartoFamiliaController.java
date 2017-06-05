/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.controllers;

import com.dbproject.systay.beans.QuartoFamilia;
import com.dbproject.systay.services.interfaces.QuartoFamiliaService;
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
 * @author araujomarianna
 */
@Controller
public class QuartoFamiliaController{
    
    @Autowired
    public QuartoFamiliaService quartoFamiliaService;
    
    @RequestMapping("/cadastrarquartofamilia")  
    public ModelAndView showform(){  
        return new ModelAndView("cadastrarquartofamilia","command",new QuartoFamilia());  
    } 
    
    @RequestMapping(value="/salvarquartofamilia",method = RequestMethod.POST)  
    public ModelAndView cadastrar(@ModelAttribute("QuartoFamilia") QuartoFamilia quartofamilia){
        quartoFamiliaService.cadastrar(quartofamilia);
        return new ModelAndView("redirect:/listarquartofamilia");
    }
    
    @RequestMapping("/listarquartofamilia")  
    public ModelAndView listarquartofamilia(){
        List<QuartoFamilia> list = quartoFamiliaService.getQuartosFamilia();  
        return new ModelAndView("listarquartofamilia","list",list);  
    }  
    
    @RequestMapping(value="/editarquartofamilia/{id}")  
    public ModelAndView editarquartofamilia(@PathVariable int id){
        QuartoFamilia qf = quartoFamiliaService.getQuartoFamilia(id);
        return new ModelAndView("editarquartofamilia","command",qf);  
    }

     /* It updates model object. */ 
    @RequestMapping(value="/editsavequartofamilia",method = RequestMethod.POST)  
    public ModelAndView editsavequartofamilia(@ModelAttribute(value="quartofamilia") QuartoFamilia quartofamilia){ 
        quartoFamiliaService.atualizarQuartoFamilia(quartofamilia);
        return new ModelAndView("redirect:/listarquartofamilia");  
    }
    
    @RequestMapping(value="/deletarquartofamilia/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){
        quartoFamiliaService.deletarQuartoFamilia(id);  
        return new ModelAndView("redirect:/listarquartofamilia"); 
    }  
    
    @RequestMapping(value = "/exibirquartofamilia/{id}",method = RequestMethod.GET)  
    public ModelAndView exibirquartofamilia(@PathVariable int id) {
        QuartoFamilia quartofamilia = quartoFamiliaService.getQuartoFamilia(id);
        return new ModelAndView("viewquartofamilia", "quartofamilia", quartofamilia);  
    }
    
}
