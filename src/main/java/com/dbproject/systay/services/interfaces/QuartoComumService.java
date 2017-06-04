/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.interfaces;

import com.dbproject.systay.beans.QuartoComum;
import java.util.List;

/**
 *
 * @author araujomarianna
 */
public interface QuartoComumService {
    
    QuartoComum getQuartoComum(int id);
    int cadastrar(QuartoComum quartocomum);
    List<QuartoComum> getQuartosComuns();
    void atualizarQuartoComum(QuartoComum quartocomum);
    int deletarQuartoComum(int id);

   // public void deletarQuartoComum(String id);
    
}
