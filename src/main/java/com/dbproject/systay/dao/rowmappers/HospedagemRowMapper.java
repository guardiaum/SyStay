/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Hospedagem;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author johny
 */
public class HospedagemRowMapper implements RowMapper<Hospedagem> {

    @Override
    public Hospedagem mapRow(ResultSet rs, int i) throws SQLException {
        Hospedagem hos = new Hospedagem();
        hos.setId(rs.getLong("id"));
        hos.setDataCheckin(rs.getDate("checkin"));
        hos.setDataCheckout(rs.getDate("checkout"));   
        Administrador adm = new Administrador();
        adm.setNumeroDocumento(rs.getString("responsavel_doc"));
        hos.setResponsavel(adm);
        //hos.setReserva(new Reserva());
        hos.setResto_reserva(rs.getDouble("resto_reserva"));
        return hos;
    }
    
}
