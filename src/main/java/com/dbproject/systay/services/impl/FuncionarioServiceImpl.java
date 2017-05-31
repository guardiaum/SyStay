/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.impl;

import com.dbproject.systay.beans.Funcionario;
import com.dbproject.systay.beans.Login;
import com.dbproject.systay.dao.interfaces.FuncionarioDao;
import com.dbproject.systay.services.interfaces.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author johny
 */
public class FuncionarioServiceImpl implements FuncionarioService{
    @Autowired
    public FuncionarioDao funcionarioDao;

    @Override
    public void register(Funcionario funcionario) {
        funcionarioDao.cadastrar(funcionario);
    }

    @Override
    public boolean validarUsuario(Login login) {
        return funcionarioDao.validarUsuario(login);
    }
    
    
}
