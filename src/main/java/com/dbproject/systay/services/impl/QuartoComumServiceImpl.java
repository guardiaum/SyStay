/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.impl;

import com.dbproject.systay.beans.QuartoComum;
import com.dbproject.systay.dao.interfaces.QuartoComumDao;
import com.dbproject.systay.services.interfaces.QuartoComumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author araujomarianna
 */
public class QuartoComumServiceImpl implements QuartoComumService{

    @Autowired
    public QuartoComumDao quartoComumDao;
    
    @Override
    public QuartoComum getQuartoComum(int id) {
        return quartoComumDao.getQuartoComum(id);
    }

    @Override
    public int cadastrar(QuartoComum quartocomum) {
       return quartoComumDao.cadastrar(quartocomum);
    }

    @Override
    public List<QuartoComum> getQuartosComuns() {
        return quartoComumDao.getQuartoComuns();
    }

    @Override
    public void atualizarQuartoComum(QuartoComum quartocomum) {
        quartoComumDao.atualizarQuartoComum(quartocomum);
    }

    @Override
    public int deletarQuartoComum(int id) {
        return quartoComumDao.deletarQuartoComum(id);
    }
    
}
