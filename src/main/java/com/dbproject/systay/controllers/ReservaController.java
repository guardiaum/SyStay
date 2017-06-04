/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.controllers;

import com.dbproject.systay.beans.Reserva;
import com.dbproject.systay.services.interfaces.ReservaService;
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
public class ReservaController {
    
    @Autowired             
    public ReservaService reservaservice;
    
    @RequestMapping("/cadastrarreserva")  
    public ModelAndView showform(){  
        return new ModelAndView("cadastrarreserva","command",new Reserva());  
    }  
    
    @RequestMapping(value="/salvarreserva",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("reserva") Reserva reserva){  
        reservaservice.save(reserva);  
        return new ModelAndView("redirect:/listarreservas");
    }  
 
    @RequestMapping("/listarreservas")  
    public ModelAndView listarhospedes(){  
        List<Reserva> list=reservaservice.getReservas();
        return new ModelAndView("listarreservas","list",list);  
    }  
     
    @RequestMapping(value="/editarreserva/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Reserva reserva=reservaservice.getReservaById(id);  
        return new ModelAndView("editarreserva","command",reserva);  
    }  

    @RequestMapping(value="/editsavereserva",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("reserva") Reserva reserva){  
        reservaservice.update(reserva);  
        return new ModelAndView("redirect:/listarreservas");  
    }  

    @RequestMapping(value="/daletarreserva/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        reservaservice.delete(id);  
        return new ModelAndView("redirect:/listarreservas");  
    }
    
    @RequestMapping(value = "/exibirreserva/{id}",method = RequestMethod.GET)  
    public ModelAndView exibirhospede(@PathVariable int id) {
        Reserva reserva = reservaservice.getReservaById(id);
        return new ModelAndView("viewreserva", "reserva", reserva);  
    }
}    
