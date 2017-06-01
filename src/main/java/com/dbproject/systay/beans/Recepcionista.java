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
public class Recepcionista extends Funcionario{
    private double bonus;

    public Recepcionista() {
    }

    public Recepcionista(double salario, Date dataAdmissao, Login login, String cpf, String nome, Endereco endereco, Date data_nascimento, Telefone telefone) {
        super(salario, dataAdmissao, login, cpf, nome, endereco, data_nascimento, telefone);
    }

    public Recepcionista(double bonus, double salario, Date dataAdmissao, Login login, String cpf, String nome, Endereco endereco, Date data_nascimento, Telefone telefone) {
        super(salario, dataAdmissao, login, cpf, nome, endereco, data_nascimento, telefone);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    
}
