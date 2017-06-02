/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.interfaces;

import com.dbproject.systay.beans.Login;

/**
 *
 * @author johny
 */
public interface LoginService {
    Login validarUsuario(Login login);
    boolean criarUsuario(Login login);
    boolean deletarUsuario(String username);
    Login atualizarUsuario(Login login);
}
