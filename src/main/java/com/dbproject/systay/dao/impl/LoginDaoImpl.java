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
    //@Inject private LoginRowMapper loginRowMapper;
    
    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }
    
    @Override
    public Login validarUsuario(Login login) {
        String GET_SQL = "SELECT * FROM tb_login WHERE username = '" + login.getUsername() + "'";
        return template.queryForObject(GET_SQL, new LoginRowMapper());
    }
}
