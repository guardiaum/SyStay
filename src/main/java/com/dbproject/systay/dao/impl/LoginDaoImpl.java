/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Login;
import com.dbproject.systay.dao.interfaces.LoginDao;
import com.dbproject.systay.dao.rowmappers.LoginRowMapper;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johny
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
    private JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }
    
    @Override
    public Login validarUsuario(Login login) {
        String GET_SQL = "SELECT * FROM tb_login "
                + "WHERE username = '" + login.getUsername() + "' AND senha='"+login.getSenha()+"'";
        List<Login> logins = template.query(GET_SQL, new LoginRowMapper());
        return logins.size()>0 ? logins.get(0) : null;
    }

    @Override
    public boolean criarUsuario(Login login) {
        String INSERT_SQL = "INSERT INTO tb_login "
                + "VALUES(tp_login('"+login.getUsername()+"','"+login.getSenha()+"'))";
        return template.update(INSERT_SQL)!=0;
    }

    @Override
    public boolean deletarUsuario(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login atualizarUsuario(Login login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
