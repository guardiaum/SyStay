/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Pessoa;
import com.dbproject.systay.beans.Telefone;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author johny
 */

public class PessoaDaoUtil {
    
    public List<Telefone> getTelefones(Pessoa f, String tabela, JdbcTemplate template) {
        List<Telefone> fones = new ArrayList();
        
        String sql = "SELECT f.cod_area||' '||f.numero||'' as fone "
                + "FROM "+tabela+" a, TABLE(a.lista_fones) f "
                + "WHERE a.numerodocumento='"+f.getNumeroDocumento()+"'";
        
        System.out.println("com.dbproject.systay.dao.impl.PessoaDaoUtil.getTelefones()");
        System.out.println(sql);
        List<String> auxFones = template.query(sql, new RowMapper<String>(){
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString("fone");
            }
        });
        
        for(String fone : auxFones){
            String cod_area = (fone.split(" "))[0];
            String numero = (fone.split(" "))[1];
            fones.add(new Telefone(cod_area, numero));
        }
        
        return !fones.isEmpty()?fones:null;
    }
}
