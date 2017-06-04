/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Login;
import com.dbproject.systay.beans.Reserva;
import com.dbproject.systay.dao.interfaces.ReservaDao;
import com.dbproject.systay.dao.rowmappers.ReservaRowMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chaina
 */


@Repository("reservaDao")
public class ReservaDaoImpl implements ReservaDao{
     
  
    private JdbcTemplate template; 
 
    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }  


    @Override
    public int save(Reserva r) { 
        
        Date date = new Date();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");    
        String  dataCadastro = dateFormat.format(date); 
        String  dataEntrada = dateFormat.format(r.getDataEntrada());   
        String  dataSaida = dateFormat.format(r.getDataSaida());
        r.setTotal_reserva(800);

//        String query="insert into tb_reserva (id, total_reserva, dataCadastro, dataEntrada, dataSaida, observacao, responsavelGerencia) "
//                + "values(sq_reserva.nextval,"+r.getTotal_reserva()+",'"+dataCadastro+"','"+dataEntrada+"','"+dataSaida+"','"
//                +r.getObservacao()+"', (SELECT REF (A) FROM tb_administrador A WHERE A.login.username = "
//                + "'"+r.getResponsavelGerencia().getLogin().getUsername()+"'))"; 

        String query="insert into tb_reserva (id, total_reserva, dataCadastro, dataEntrada, dataSaida, observacao, responsavelGerencia, hospede)"
                + "values(sq_reserva.nextval,"+r.getTotal_reserva()+",'"+dataCadastro+"','"+dataEntrada+"','"+dataSaida+"','"
                +r.getObservacao()+"', (SELECT REF (A) FROM tb_administrador A WHERE A.login.username = "
                + "'"+r.getResponsavelGerencia().getLogin().getUsername()+"'), (SELECT REF (H) FROM tb_hospede H "
                + "WHERE H.numeroDocumento = '"+r.getHospede().getNumeroDocumento()+"'))"; 
        System.err.println(query);
        return template.update(query);
    }

    @Override
    public int update(Reserva r) { 
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
        String  dataEntrada = dateFormat.format(r.getDataEntrada());   
        String  dataSaida = dateFormat.format(r.getDataSaida());
        
        String query="update tb_reserva R set R.dataEntrada='"+dataEntrada+"',"
                + "R.dataSaida='"+dataSaida+"', R.observacao='"+r.getObservacao()+"'"
                + "where id="+r.getId()+"";          
        return template.update(query);  
    }

    @Override
    public int delete(int id) {  
        String query="delete from tb_reserva where id='"+id+"'";  
        return template.update(query);  
    }
    
    @Override
    public List<Reserva> getReservas() { 
        String query = "SELECT A.id as id, A.total_reserva as total_reserva, "+
                "A.dataCadastro as dataCadastro,A.dataEntrada as dataEntrada, "
                 + "A.dataSaida as dataSaida, A.responsavelGerencia.login.username as username, "
                + "A.hospede.numeroDocumento as numeroDocumento, A.hospede.nome as nome, "
                + "A.dataCancelamento as dataCancelamento, A.observacao "+
                "FROM tb_reserva A";        
        List<Reserva> reservas = template.query(query, new ReservaRowMapper());        
        return reservas;
    }
    
    
    @Override
    public Reserva getReservaById(int id) { 
        String query = "SELECT A.id as id, A.total_reserva as total_reserva, "+
                "A.dataCadastro as dataCadastro,A.dataEntrada as dataEntrada, "
                 + "A.dataSaida as dataSaida, A.responsavelGerencia.login.username as username,"
                + "A.hospede.numeroDocumento as numeroDocumento, A.hospede.nome as nome, "
                + " A.dataCancelamento as dataCancelamento, A.observacao "+
                "FROM tb_reserva A WHERE A.id='"+id+"'";
        List<Reserva> reservas = template.query(query, new ReservaRowMapper());
        return reservas.get(0);
    }
    
}
