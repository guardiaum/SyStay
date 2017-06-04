/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.interfaces;

import com.dbproject.systay.beans.Reserva;
import java.util.List;

/**
 *
 * @author Chaina
 */
public interface ReservaService {
    int save (Reserva reserva);
    int update(Reserva reserva);
    int delete(int id);
    List<Reserva> getReservas();
    Reserva getReservaById(int id);    
}
