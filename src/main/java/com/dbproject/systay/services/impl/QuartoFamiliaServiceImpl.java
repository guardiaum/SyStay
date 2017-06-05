/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.impl;

import com.dbproject.systay.beans.QuartoFamilia;
import com.dbproject.systay.dao.interfaces.QuartoFamiliaDao;
import com.dbproject.systay.services.interfaces.QuartoFamiliaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class QuartoFamiliaServiceImpl implements QuartoFamiliaService {
    
    @Autowired
    public QuartoFamiliaDao quartoFamiliaDao;

    @Override
    public QuartoFamilia getQuartoFamilia(int id) {
        return quartoFamiliaDao.getQuartoFamilia(id);
    }

    @Override
    public int cadastrar(QuartoFamilia quartofamilia) {
        return quartoFamiliaDao.cadastrar(quartofamilia);
    }

    @Override
    public List<QuartoFamilia> getQuartosFamilia() {
        return quartoFamiliaDao.getQuartosFamilia();
    }

    @Override
    public boolean atualizarQuartoFamilia(QuartoFamilia quartofamilia) {
        return quartoFamiliaDao.atualizarQuartoFamilia(quartofamilia);
    }

    @Override
    public int deletarQuartoFamilia(int id) {
        return quartoFamiliaDao.deletarQuartoFamilia(id);
    }
    
}
