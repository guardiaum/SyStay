/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.interfaces;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Login;
import java.util.List;

/**
 *
 * @author johny
 */
public interface AdminService {
    Administrador getAdministrador(String numeroDocumento);
    Administrador cadastrar(Administrador administrador);
    List<Administrador> getAdministradores();
    boolean atualizarAdministrador(Administrador admin);
    boolean deletarAdministrador(String numeroDocumento);
}
