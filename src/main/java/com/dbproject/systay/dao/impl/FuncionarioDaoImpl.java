/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Funcionario;
import com.dbproject.systay.beans.Login;
import com.dbproject.systay.dao.interfaces.FuncionarioDao;
import com.dbproject.systay.dao.rowmappers.FuncionarioRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johny
 */
@Repository("funcionaorioDao")
public class FuncionarioDaoImpl implements FuncionarioDao {
    @Inject private NamedParameterJdbcOperations jdbcTemplate;
    @Inject private FuncionarioRowMapper funcionarioRowMapper;
    
    @Override
    public void cadastrar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario validarUsuario(Login login) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("username", login.getUsername());
        
        String GET_SQL = "SELECT f.* FROM tb_funcionario as f, tb_login as l "
                + "WHERE f. = :locationId";
        
        //List<Funcionario> funcionarios = jdbcTemplate.query(GET_SQL, params, funcionarioRowMapper);
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario f1 = new Funcionario();
        f1.setNumeroDocumento("1234555");
        f1.setNome("Joao");
        f1.setLogin(new Login("joao","1234"));
        funcionarios.add(f1);
        return funcionarios.isEmpty()?null:funcionarios.get(0);
    }

    @Override
    public List<Funcionario> getFuncionarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFuncionario(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
