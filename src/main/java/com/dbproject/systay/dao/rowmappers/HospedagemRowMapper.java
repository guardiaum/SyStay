/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Hospedagem;
import com.dbproject.systay.beans.Reserva;
import com.dbproject.systay.dao.interfaces.AdminDao;
import com.dbproject.systay.dao.interfaces.ReservaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author johny
 */
public class HospedagemRowMapper implements RowMapper<Hospedagem> {
        
    @Override
    public Hospedagem mapRow(ResultSet rs, int i) throws SQLException {
        Hospedagem hos = new Hospedagem();
        hos.setId(rs.getInt("id"));
        hos.setDataCheckin(rs.getDate("datacheckin"));
        hos.setDataCheckout(rs.getDate("datacheckout"));   
        hos.setResto_reserva(rs.getDouble("resto_reserva"));
        
        Administrador a = new Administrador();
        a.setNumeroDocumento(rs.getString("responsavelgerencia"));
        hos.setResponsavel(a);
       
        Reserva r = new Reserva();
        r.setId(rs.getInt("reserva"));
        hos.setReserva(r);
        return hos;
    }
    
}
