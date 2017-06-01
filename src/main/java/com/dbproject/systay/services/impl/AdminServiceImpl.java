/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.impl;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Login;
import com.dbproject.systay.dao.interfaces.AdminDao;
import com.dbproject.systay.services.interfaces.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author johny
 */
public class AdminServiceImpl implements AdminService{
    @Autowired
    public AdminDao adminDao;

    @Override
    public Administrador getAdministrador(String numeroDocumento) {
        return adminDao.getAdministrador(numeroDocumento);
    }

    @Override
    public void cadastrar(Administrador administrador) {
        adminDao.cadastrar(administrador);
    }

    @Override
    public List<Administrador> getAdministradores() {
        return adminDao.getAdministradores();
    }

    @Override
    public void atualizarAdministrador(Administrador admin) {
        adminDao.atualizarAdministrador(admin);
    }

    @Override
    public void deletarAdministrador(String numeroDocumento) {
        adminDao.deletarAdministrador(numeroDocumento);
    }
    
    
    
}
