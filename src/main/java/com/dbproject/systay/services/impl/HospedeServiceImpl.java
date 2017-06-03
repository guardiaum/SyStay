/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.impl;

import com.dbproject.systay.beans.Hospede;
import com.dbproject.systay.dao.interfaces.HospedeDao;
import com.dbproject.systay.services.interfaces.HospedeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chaina
 */
public class HospedeServiceImpl implements HospedeService{
    @Autowired
    public HospedeDao hospedeDao;
    
    @Override
    public int save(Hospede hospede) {
        return hospedeDao.save(hospede);
    }
    
    @Override
    public int update(Hospede hospede) {
        return hospedeDao.update(hospede);
    }

    @Override
    public int delete(String numeroDocumento) {
        return hospedeDao.delete(numeroDocumento);
    }

    @Override
    public List<Hospede> getHospedes() {
        return hospedeDao.getHospedes();
    }

    @Override
    public Hospede getHospedeById(String numeroDocumento) {
        return hospedeDao.getHospedeById(numeroDocumento);
    }
   
    
}
