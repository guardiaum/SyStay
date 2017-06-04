/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.QuartoComum;
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
        qc.setArea(rs.getDouble("area"));
        //qc.setFotos(rs.)
        qc.setObservacao(rs.getString("observacao"));
        qc.setQtd_camas(rs.getInt("qt_camas"));
        qc.setRamal(rs.getString("ramal"));
       // qc.setTem_varanda(Char.rs.getString(""));
        qc.setTipo_camas(rs.getString("cama"));
        qc.setValor_diaria(rs.getFloat("valor_diaria"));
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
