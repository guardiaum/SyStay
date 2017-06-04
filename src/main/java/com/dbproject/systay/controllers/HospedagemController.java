/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.controllers;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Hospedagem;
import com.dbproject.systay.beans.Hospede;
import com.dbproject.systay.services.interfaces.HospedagemService;
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
 * @author johny
 */
@Controller
public class HospedagemController {
    
    @Autowired
    public HospedagemService hospedagemService;
    @Autowired
    public HospedeService hospedeService;
    
    @RequestMapping(value="/cadastrarhospedagem", method = RequestMethod.GET)  
    public ModelAndView showformHospedagem(){
        ModelAndView model = new ModelAndView("cadastrarhospedagem");
        //model.addObject("reserva",new Reserva());
        model.addObject("command",new Hospedagem());
        return model;
    }
    
    @RequestMapping(value="/salvarhospedagem",method = RequestMethod.POST)  
    public ModelAndView cadastrarHospedagem(@ModelAttribute("Hospedagem") Hospedagem hospedagem){
        hospedagem = hospedagemService.cadastrarHospedagem(hospedagem);
        ModelAndView mv = new ModelAndView("viewadmin");
        mv.addObject("hospedagem", hospedagem);
        return mv;
    }  
    
    /* It provides list of employees in model object */  
    @RequestMapping(value="/listarhospedagens",method = RequestMethod.GET)
    public ModelAndView viewHospedagens(){  
        List<Hospedagem> list = hospedagemService.getHospedagens();  
        return new ModelAndView("listarhospedagens","list",list);  
    }  
    
    @RequestMapping(value="/editarhospedagem/{id}")  
    public ModelAndView editarhospedagem(@PathVariable long id){  
        Hospedagem hospedagem = hospedagemService.getHospedagem(id);  
        return new ModelAndView("editarhospedagem","command", hospedagem);  
    }  
    
    /* It updates model object. */ 
    @RequestMapping(value="/editsavehospedagem", method = RequestMethod.POST)  
    public ModelAndView atualizarHospedagem(@ModelAttribute("hospedagem") Hospedagem hospedagem){  
        hospedagemService.atualizarHospedagem(hospedagem);  
        return new ModelAndView("redirect:/listarhospedagens");  
    }
    
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deletarhospedagem/{id}",method = RequestMethod.GET)  
    public ModelAndView deleteHospedagem(@PathVariable long id){
        hospedagemService.deletarHospedagem(id);  
        return new ModelAndView("redirect:/listarhospedagens"); 
    }  
    
    @RequestMapping(value = "/exibirhospedagem/{id}",method = RequestMethod.GET)  
    public ModelAndView exibirHospedagem(@PathVariable long id) {
        Hospedagem hospedagem = hospedagemService.getHospedagem(id);
        return new ModelAndView("viewhospedagem", "hospedagem", hospedagem);  
    }
}
