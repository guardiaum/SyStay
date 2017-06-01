/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;

import com.dbproject.systay.beans.Funcionario;
import com.dbproject.systay.beans.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author johny
 */
@Component
public class FuncionarioRowMapper implements RowMapper<Funcionario> {

    @Override
    public Funcionario mapRow(ResultSet rs, int i) throws SQLException {
        Funcionario funcionario = new Funcionario();
            funcionario.setNumeroDocumento(rs.getString("cpf"));
            funcionario.setDataAdmissao(rs.getDate("data_admissao"));
            funcionario.setDataDemissao(rs.getDate("data_admissao"));

            Login l = new Login(rs.getString("username"), rs.getString("senha"));
            funcionario.setLogin(l);
            
            return funcionario;
    }
    
}
