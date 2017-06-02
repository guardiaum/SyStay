/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Endereco;
import com.dbproject.systay.beans.Login;
import com.dbproject.systay.beans.Telefone;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
        adm.setData_nascimento(rs.getDate("data_nascimento"));
        adm.setDataAdmissao(rs.getDate("dataadimissao"));
        adm.setSalario(rs.getDouble("salario"));
        adm.setCargo(rs.getString("cargo"));
        adm.setEndereco(new Endereco(rs.getString("rua"), 
                rs.getInt("numero"), rs.getString("complemento"), rs.getString("bairro"), 
                rs.getString("cidade"), rs.getString("estado"), rs.getInt("cep")));
        adm.setLogin(new Login(rs.getString("username"),rs.getString("senha")));
        return adm;
    }
    
}
