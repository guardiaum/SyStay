/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Hospedagem;
import com.dbproject.systay.beans.Reserva;
import com.dbproject.systay.dao.interfaces.AdminDao;
import com.dbproject.systay.dao.interfaces.HospedagemDao;
import com.dbproject.systay.dao.interfaces.ReservaDao;
import com.dbproject.systay.dao.rowmappers.HospedagemRowMapper;
import com.dbproject.systay.services.interfaces.AdminService;
import com.dbproject.systay.services.interfaces.ReservaService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author johny
 */
public class HospedagemDaoImpl implements HospedagemDao{
        
    private JdbcTemplate template;
    @Autowired
    private ReservaService reservaService;
    @Autowired
    public AdminService adminService;
    
    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }  
    
    @Override
    public Hospedagem getHospedagem(long id) {
        String sql = "SELECT H.id as id, H.datacheckin as datacheckin, H.datacheckout as datacheckout, "
                + " H.resto_reserva as resto_reserva, H.responsavelGerencia.numeroDocumento as responsavelgerencia, "
                + " H.reserva.id as reserva FROM tb_hospedagem H WHERE H.id="+id;
        Hospedagem h = template.queryForObject(sql, new HospedagemRowMapper());
        h.setReserva(reservaService.getReservaById(h.getReserva().getId()));
        h.setResponsavel(adminService.getAdministrador(h.getResponsavel().getNumeroDocumento()));
        return h;
    }

    @Override
    public Hospedagem cadastrarHospedagem(Hospedagem hospedagem) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String checkin = dateFormat.format(hospedagem.getReserva().getDataEntrada());
        String checkout =  dateFormat.format(hospedagem.getReserva().getDataSaida());
        
        String sql = "INSERT INTO tb_hospedagem(id, resto_reserva, datacheckin, "
                + "responsavelgerencia, reserva) VALUES(sq_hospedagem.nextval, "+
                hospedagem.getResto_reserva() + ", '" 
                + checkin+"', "
                + "(SELECT REF(A) FROM tb_administrador A WHERE A.numeroDocumento="+hospedagem.getResponsavel().getNumeroDocumento()+"),"
                + "(SELECT REF(R) FROM tb_reserva R WHERE R.id="+hospedagem.getReserva().getId()+"))";
        
        hospedagem = template.queryForObject(sql, new RowMapper<Hospedagem>(){
            @Override
            public Hospedagem mapRow(ResultSet rs, int i) throws SQLException {
                Hospedagem hos = new Hospedagem();
                hos.setId(rs.getInt("id"));
                hos.setResto_reserva(rs.getDouble("resto_reserva"));
                hos.setDataCheckin(rs.getDate("datacheckin"));
                
                Administrador a = new Administrador();
                a.setNumeroDocumento(rs.getString("responsavelgerencia"));
                hos.setResponsavel(a);

                Reserva r = new Reserva();
                r.setId(rs.getInt("reserva"));
                hos.setReserva(r);
                return hos;
            }
            
        });
        return hospedagem;
    }

    @Override
    public List<Hospedagem> getHospedagens() {
        String sql = "SELECT H.id as id, H.datacheckin as datacheckin, H.dataCheckout as datacheckout, H.reserva.id as reserva FROM tb_hospedagem H";
        return template.query(sql, new RowMapper<Hospedagem>() {
            @Override
            public Hospedagem mapRow(ResultSet rs, int row) throws SQLException {
                Hospedagem a = new Hospedagem();
                a.setId(rs.getInt("id"));
                a.setDataCheckin(rs.getDate("datacheckin"));
                a.setDataCheckout(rs.getDate("datacheckout"));
                //Reserva r = reservaService.getReservaById(rs.getInt("reserva"));
                Reserva r = new Reserva();
                r.setId(rs.getInt("reserva"));
                a.setReserva(r);
                return a;
            }
        });
    }

    @Override
    public boolean atualizarHospedagem(Hospedagem h) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String checkout =  dateFormat.format(h.getDataCheckout());
        
        String sql = "UPDATE tb_hospedagem H set H.resto_reserva=0, "
                + "H.dataCheckout='"+checkout+"' WHERE h.id="+h.getId();
        return template.update(sql)!=0;
    }

    @Override
    public boolean deletarHospedagem(long id) {
        //boolean result = reservaDao.deleteReserva(id);
        String sql = "DELETE FROM tb_hospedagem WHERE id="+id;
        return template.update(sql)!=0;
    }
    
}
