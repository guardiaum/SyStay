/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import com.dbproject.systay.beans.Hospede;
import com.dbproject.systay.beans.Telefone;
import com.dbproject.systay.dao.interfaces.HospedeDao;
import com.dbproject.systay.dao.rowmappers.HospedeRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chaina
 */

@Repository("hospedeDao")
public class HospedeDaoImpl implements HospedeDao{
     
  
    private JdbcTemplate template; 
    private PessoaDaoUtil pessoa = new PessoaDaoUtil(); 
 
    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }  
    
    @Override
    public int save(Hospede h){ 
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");    
        String  data_nascimento = dateFormat.format(h.getData_nascimento());
        
        String query="insert into tb_hospede(numeroDocumento,nome, data_nascimento,lista_fones, endereco, observacao) "
                + "values('"+h.getNumeroDocumento()+"','"+h.getNome()+"','"+data_nascimento+"', "
                + "tp_fones(tp_fone('"+h.getTelefone().get(0).getCod_area()+"', '"+h.getTelefone().get(0).getNumero()+"'), "
                + "tp_fone('"+h.getTelefone().get(1).getCod_area()+"', '"+h.getTelefone().get(1).getNumero()+"'), "
                + "tp_fone('"+h.getTelefone().get(2).getCod_area()+"', '"+h.getTelefone().get(2).getNumero()+"'), "
                + "tp_fone('"+h.getTelefone().get(3).getCod_area()+"', '"+h.getTelefone().get(3).getNumero()+"')), "
                + "tp_endereco('"+h.getEndereco().getRua()+"',"+h.getEndereco().getNumero()+",'"+h.getEndereco().getComplemento()+"',"
                + "'"+h.getEndereco().getBairro()+"','"+h.getEndereco().getCidade()+"','"+h.getEndereco().getEstado()+"',"
                + ""+h.getEndereco().getCep()+"),'"+h.getObservacao()+"')"; 
        return template.update(query);  
    }  
    
    @Override
    public int update(Hospede h){  
        String query="update tb_hospede H set H.numeroDocumento='"+h.getNumeroDocumento()+"', "
                + "H.nome='"+h.getNome()+"', H.endereco.rua='"+h.getEndereco().getRua()+"',"
                + "H.endereco.numero="+h.getEndereco().getNumero()+", H.endereco.complemento='"+h.getEndereco().getComplemento()+"',"
                + "H.endereco.bairro='"+h.getEndereco().getBairro()+"',H.endereco.cidade='"+h.getEndereco().getCidade()+"',"
                + "H.endereco.estado='"+h.getEndereco().getEstado()+"', H.endereco.cep="+h.getEndereco().getCep()+","
                + "H.observacao='"+h.getObservacao()+"'where numeroDocumento='"+h.getNumeroDocumento()+"'";  
        return template.update(query);  
    }  
    
    @Override
    public int delete(String numeroDocumento){  
        String query="delete from tb_hospede where numeroDocumento='"+numeroDocumento+"'";  
        return template.update(query);  
    }  
    
    @Override
    public Hospede getHospedeById(String numeroDocumento){  
        String query = "SELECT A.nome as nome, A.numerodocumento as numerodocumento, "+
                "A.data_nascimento as data_nascimento,A.endereco.rua as rua, "
                 + "A.endereco.numero as numero, "+
                "A.endereco.complemento as complemento, A.endereco.bairro as bairro, "+
                "A.endereco.cidade as cidade, A.endereco.estado as estado, A.endereco.cep as cep, A.observacao "+
                "FROM tb_hospede A WHERE A.numerodocumento='"+numeroDocumento+"'";
             
        System.out.println(query);
        List<Hospede> hospedes = template.query(query, new HospedeRowMapper());
        List<Hospede> aux = new ArrayList();
        for(Hospede h : hospedes){
            System.out.println("Foooooooooor");
            List<Telefone> telefones = pessoa.getTelefones(h, "tb_hospede",template);
            h.setTelefone(telefones);
            aux.add(h);
        }
        return hospedes.size()>0 ? aux.get(0) : hospedes.get(0);
    }
    
    @Override
    public List<Hospede> getHospedes(){          
        return template.query("select * from tb_hospede",new RowMapper<Hospede>(){  
            public Hospede mapRow(ResultSet rs, int row) throws SQLException {  
                Hospede h=new Hospede();  
                h.setNumeroDocumento(rs.getString(1));  
                h.setNome(rs.getString(2));  
                return h;  
            }  
        });  
    }
}  
