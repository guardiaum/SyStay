/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.impl;

import com.dbproject.systay.beans.Hospedagem;
import com.dbproject.systay.dao.interfaces.HospedagemDao;
import com.dbproject.systay.services.interfaces.HospedagemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author johny
 */
public class HospedagemServiceImpl implements HospedagemService{

    @Autowired
    public HospedagemDao hospedagemDao;
    
    @Override
    public Hospedagem getHospedagem(long id) {
        return hospedagemDao.getHospedagem(id);
    }

    @Override
    public Hospedagem cadastrarHospedagem(Hospedagem hospedagem) {
        return hospedagemDao.cadastrarHospedagem(hospedagem);
    }

    @Override
    public List<Hospedagem> getHospedagens() {
        return hospedagemDao.getHospedagens();
    }

    @Override
    public boolean atualizarHospedagem(Hospedagem hospedagem) {
        return hospedagemDao.atualizarHospedagem(hospedagem);
    }

    @Override
    public boolean deletarHospedagem(long id) {
        return hospedagemDao.deletarHospedagem(id);
    }
    
}
