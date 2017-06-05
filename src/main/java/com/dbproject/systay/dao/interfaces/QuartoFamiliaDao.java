/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.interfaces;

import com.dbproject.systay.beans.QuartoFamilia;
import java.util.List;

/**
 *
 * @author araujomarianna
 */
public interface QuartoFamiliaDao {
    
    QuartoFamilia getQuartoFamilia(int id);
    int cadastrar(QuartoFamilia quartofamilia);
    List<QuartoFamilia> getQuartosFamilia();
    boolean atualizarQuartoFamilia(QuartoFamilia quartofamilia);
    int deletarQuartoFamilia(int id);
    
}
