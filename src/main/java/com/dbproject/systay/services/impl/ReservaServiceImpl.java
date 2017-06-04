/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.impl;

import com.dbproject.systay.beans.Reserva;
import com.dbproject.systay.dao.interfaces.ReservaDao;
import com.dbproject.systay.services.interfaces.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chaina
 */
public class ReservaServiceImpl implements ReservaService{
    @Autowired
    public ReservaDao reservaDao;

    @Override
    public int save(Reserva reserva) {
        return reservaDao.save(reserva);
    }

    @Override
    public int update(Reserva reserva) {
        return reservaDao.update(reserva);
    }

    @Override
    public int delete(int id) {
        return reservaDao.delete(id);
    }

    @Override
    public List<Reserva> getReservas() {
        return reservaDao.getReservas();
    }

    @Override
    public Reserva getReservaById(int id) {
        return reservaDao.getReservaById(id);
    }
    
}
