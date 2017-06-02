/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import com.dbproject.systay.beans.Hospede;
import com.dbproject.systay.dao.interfaces.HospedeDao;
import java.text.SimpleDateFormat;
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

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");    
        String data_nascimento = dateFormat.format(h.getData_nascimento());
    
        String query="insert into tb_hospede(numeroDocumento,nome, data_nascimento,lista_fones, endereco, observacao) values('"+h.getNumeroDocumento()+"','"+h.getNome()+"','"+data_nascimento+"', tp_fones(tp_fone('"+h.getTelefone().get(0).getCod_area()+"', '"+h.getTelefone().get(0).getNumero()+"'), tp_fone('"+h.getTelefone().get(1).getCod_area()+"', '"+h.getTelefone().get(1).getNumero()+"'), tp_fone('"+h.getTelefone().get(2).getCod_area()+"', '"+h.getTelefone().get(2).getNumero()+"'), tp_fone('"+h.getTelefone().get(3).getCod_area()+"', '"+h.getTelefone().get(3).getNumero()+"')), tp_endereco('"+h.getEndereco().getRua()+"',"+h.getEndereco().getNumero()+",'"+h.getEndereco().getComplemento()+"','"+h.getEndereco().getBairro()+"','"+h.getEndereco().getCidade()+"','"+h.getEndereco().getEstado()+"',"+h.getEndereco().getCep()+"),'"+h.getObservacao()+"')"; 
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
