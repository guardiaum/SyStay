/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.Hospede;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Chaina
 */
public class HospedeRowMapper implements RowMapper<Hospede>{

    @Override
    public Hospede mapRow(ResultSet rs, int i) throws SQLException {
        Hospede h = new Hospede();       
        h.setNumeroDocumento(rs.getString("numerodocumento"));
        h.setNome(rs.getString("nome"));
        h.setData_nascimento(rs.getDate("data_nascimento"));
        h.setObservacao(rs.getString("observacao"));
        return h;
    }
    
}
