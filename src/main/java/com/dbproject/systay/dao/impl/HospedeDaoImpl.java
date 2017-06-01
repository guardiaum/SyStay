/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import com.dbproject.systay.beans.Hospede;
import com.dbproject.systay.dao.interfaces.HospedeDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Chaina
 */

@Repository("hospedeDao")
public class HospedeDaoImpl implements HospedeDao{
     
  
    private JdbcTemplate template;  
 
    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }  
    
    @Override
    public int save(Hospede h){  
         //String query="insert into tb_hospede(numeroDocumento,nome) values('12', 'Johny')";  
         System.out.println("HospedeDaoImpldsa");
         System.out.println(h.getNumeroDocumento());
         System.out.println(h.getNome());
         System.out.println("HospedeDaoImplfim");
         String query="insert into tb_hospede(numeroDocumento,nome) values('"+h.getNumeroDocumento()+"',"+h.getNome()+"')";  
        return template.update(query);  
    }  
    
    @Override
    public int update(Hospede h){  
        String query="update tb_hospede set nome="+h.getNome()+"' where numeroDocumento="+h.getNumeroDocumento()+"";  
        return template.update(query);  
    }  
    
    @Override
    public int delete(String numeroDocumento){  
        String query="delete from tb_hospede where numeroDocumento="+numeroDocumento+"";  
        return template.update(query);  
    }  
//public Hospede getEmpById(String numeroDocumento){  
//    String query="select * from tb_hospede where numeroDocumento=?";  
//    return template.queryForObject(query, new Object[]{numeroDocumento},new BeanPropertyRowMapper<Hospede>(Hospede.class));  
//}  
//public List<Hospede> getEmployees(){  
//    return template.query("select * from tb_hospede",new RowMapper<Hospede>(){  
//        public Hospede mapRow(ResultSet rs, int row) throws SQLException {  
//            Hospede h=new Hospede();  
//            h.setNumeroDocumento(rs.getString(1));  
//            h.setNome(rs.getString(2));  
//            return h;  
//        }  
//    });  
//}

}  
