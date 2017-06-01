/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.dao.interfaces.AdminDao;
import com.dbproject.systay.dao.rowmappers.AdminRowMapper;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johny
 */
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{
    
    private JdbcTemplate template;
    
    @Inject private AdminRowMapper adminRowMapper;

    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }
    
    @Override
    public Administrador getAdministrador(String numeroDocumento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cadastrar(Administrador administrador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Administrador> getAdministradores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarAdministrador(Administrador administrador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarAdministrador(String numeroDocumento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
