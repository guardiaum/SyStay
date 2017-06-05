/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.interfaces;

import com.dbproject.systay.beans.QuartoComum;
import java.util.List;

/**
 *
 * @author araujomarianna
 */
public interface QuartoComumDao {
    
    QuartoComum getQuartoComum(int id);
    int cadastrar(QuartoComum quartocomum);
    List<QuartoComum> getQuartoComuns();
    boolean atualizarQuartoComum(QuartoComum quartocomum);
    int deletarQuartoComum(int id);
    
}
