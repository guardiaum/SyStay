/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.impl;

import com.dbproject.systay.beans.Login;
import com.dbproject.systay.dao.interfaces.LoginDao;
import com.dbproject.systay.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author johny
 */
public class LoginServiceImpl implements LoginService{
    
    @Autowired
    public LoginDao loginDao;
    
    @Override
    public Login validarUsuario(Login login) {
        return loginDao.validarUsuario(login);
    }

    @Override
    public boolean criarUsuario(Login login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
