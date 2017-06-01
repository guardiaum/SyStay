/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.beans;

import java.util.Date;
import java.util.List;

/**
 *
 * @author johny
 */
public class Administrador extends Funcionario{
    private String cargo;

    public Administrador() {
    }

    public Administrador(String cargo, double salario, Date dataAdmissao, Login login, String cpf, String nome, Endereco endereco, Date data_nascimento, List<Telefone> telefone) {
        super(salario, dataAdmissao, login, cpf, nome, endereco, data_nascimento, telefone);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
