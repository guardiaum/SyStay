/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Hospedagem;
import com.dbproject.systay.dao.interfaces.HospedagemDao;
import com.dbproject.systay.dao.rowmappers.HospedagemRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author johny
 */
public class HospedagemDaoImpl implements HospedagemDao{
        
    private JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }  
    
    @Override
    public Hospedagem getHospedagem(long id) {
        String sql = "SELECT H.id as id, H.checkin as checkin, H.checkout as checkout, "
                + " H.resto_reseva as resto_reserva, H.responsavelGerencia.numeroDocumento as responsavel_doc "
                + " FROM tb_hospedagem H WHERE H.id="+id;
        return template.queryForObject(sql, new HospedagemRowMapper());
    }

    @Override
    public Hospedagem cadastrarHospedagem(Hospedagem hospedagem) {
        String sql = "INSERT INTO tb_hospedagem VALUES()";
        hospedagem = template.queryForObject(sql, new HospedagemRowMapper());
        return hospedagem;
    }

    @Override
    public List<Hospedagem> getHospedagens() {
        String sql = "SELECT H.*, H.reserva.id as reserva FROM tb_hospedagem H";
        return template.query("select * from tb_hospedagem", new RowMapper<Hospedagem>() {
            @Override
            public Hospedagem mapRow(ResultSet rs, int row) throws SQLException {
                Hospedagem a = new Hospedagem();
                a.setId(rs.getInt("id"));
                a.setDataCheckin(rs.getDate("checkin"));
                a.setDataCheckout(rs.getDate("checkout"));
                //a.setReserva(new Reserva());
                return a;
            }
        });
    }

    @Override
    public boolean atualizarHospedagem(Hospedagem h) {
        String sql = "UPDATE tb_hospedagem H set H.resto_reserva="+h.getResto_reserva()+", "
                + "H.dataCheckout="+h.getDataCheckout()+" WHERE h.id="+h.getId();
        return template.update(sql)!=0;
    }

    @Override
    public boolean deletarHospedagem(long id) {
        //boolean result = reservaDao.deleteReserva(id);
        String sql = "DELETE FROM tb_hospedagem WHERE id="+id;
        return template.update(sql)!=0;
    }
    
}
