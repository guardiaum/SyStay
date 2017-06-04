/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Endereco;
import com.dbproject.systay.beans.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author johny
 */
public class AdminRowMapper implements RowMapper<Administrador>{

    @Override
    public Administrador mapRow(ResultSet rs, int i) throws SQLException {
        Administrador adm = new Administrador();
        adm.setNumeroDocumento(rs.getString("numerodocumento"));
        adm.setNome(rs.getString("nome"));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDateNasc = new java.util.Date(rs.getDate("data_nascimento").getTime());
        java.util.Date utilAdmissao = new java.util.Date(rs.getDate("dataAdimissao").getTime());
        
        adm.setData_nascimento(utilDateNasc);
        adm.setDataAdmissao(utilAdmissao);
        adm.setSalario(rs.getDouble("salario"));
        adm.setCargo(rs.getString("cargo"));
        adm.setEndereco(new Endereco(rs.getString("rua"), 
                rs.getInt("numero"), rs.getString("complemento"), rs.getString("bairro"), 
                rs.getString("cidade"), rs.getString("estado"), rs.getInt("cep")));
        adm.setLogin(new Login(rs.getString("username"),rs.getString("senha")));
        return adm;
    }
    
}
