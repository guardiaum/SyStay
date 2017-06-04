/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.Reserva;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Chaina
 */
public class ReservaRowMapper implements RowMapper<Reserva>{

    @Override
    public Reserva mapRow(ResultSet rs, int i) throws SQLException {
        Reserva r = new Reserva();  
        r.setId(rs.getInt("id"));     
        r.setObservacao(rs.getString("observacao"));
        r.setTotal_reserva(rs.getFloat("total_reserva"));
        r.setDataCadastro(rs.getDate("dataCadastro"));
        r.setDataEntrada(rs.getDate("dataEntrada"));
        r.setDataSaida(rs.getDate("dataSaida"));
        r.setDataCancelamento(rs.getDate("dataCancelamento"));
        r.getResponsavelGerencia().getLogin().setUsername(rs.getString("login"));
        return r;
    }   
}
