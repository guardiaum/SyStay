/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.rowmappers;


import com.dbproject.systay.beans.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author johny
 */
public class LoginRowMapper implements RowMapper<Login>{

    @Override
    public Login mapRow(ResultSet rs, int i) throws SQLException {
        return new Login(rs.getString("username"), rs.getString("senha"));
    }
    
}
