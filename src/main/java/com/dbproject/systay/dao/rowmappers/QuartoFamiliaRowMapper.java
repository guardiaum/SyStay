/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.QuartoFamilia;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author araujomarianna
 */
public class QuartoFamiliaRowMapper implements RowMapper<QuartoFamilia>{

    @Override
    public QuartoFamilia mapRow(ResultSet rs, int i) throws SQLException {
        QuartoFamilia qf = new QuartoFamilia();
        qf.setId(rs.getInt("id"));
        qf.setNumero(rs.getInt("numero"));
        qf.setObservacao(rs.getString("observacao"));
        
        //foto
        qf.setArea(rs.getDouble("area"));
        qf.setTem_varanda(rs.getString("tem_varanda").charAt(0));
        qf.setRamal(rs.getString("ramal"));
        qf.setValor_diaria(rs.getFloat("valor_diaria"));
        //gerente
        qf.setQtd_camas_adicionais(rs.getInt("qtd_camas_adicionais"));      
//        Administrador adm = new Administrador();
//        //adm.setNumeroDocumento(rs.getString("responsavel_doc"));
//        qf.setResponsavelGerencia(adm);
        
        return qf;
    }
    
}
