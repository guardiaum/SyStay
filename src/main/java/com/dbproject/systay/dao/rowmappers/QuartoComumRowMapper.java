/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.QuartoComum;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author araujomarianna
 */
public class QuartoComumRowMapper implements RowMapper<QuartoComum>{

    @Override
    public QuartoComum mapRow(ResultSet rs, int i) throws SQLException {
                                                                    
        QuartoComum qc = new QuartoComum();
        qc.setId(rs.getInt("id"));
        qc.setNumero(rs.getInt("numero"));
        qc.setObservacao(rs.getString("observacao"));
        
        //foto
        qc.setArea(rs.getDouble("area"));
        qc.setTem_varanda(rs.getString("tem_varanda").charAt(0));
        qc.setRamal(rs.getString("ramal"));
        qc.setValor_diaria(rs.getFloat("valor_diaria"));
        //gerente
        qc.setQtd_camas(rs.getInt("qtd_camas"));      
        qc.setTipo_camas(rs.getString("tipo_camas"));
//        Administrador adm = new Administrador();
//        //adm.setNumeroDocumento(rs.getString("responsavel_doc"));
//        qc.setResponsavelGerencia(adm);
        
        return qc;
    }
    
}
