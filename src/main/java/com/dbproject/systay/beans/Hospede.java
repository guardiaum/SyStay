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

public class Hospede extends Pessoa {
    private String observacao;
    private Administrador responsavelGerencia;

    public void setResponsavelGerencia(Administrador responsavelGerencia) {
        this.responsavelGerencia = responsavelGerencia;
    }

    public Administrador getResponsavelGerencia() {
        return responsavelGerencia;
    }

    public Hospede() {
    }
    
    public Hospede(String observacao, String numeroDocumento, String nome, Endereco endereco, Date data_nascimento, List<Telefone> telefone) {
        super(numeroDocumento, nome, endereco, data_nascimento, telefone);
        this.observacao = observacao;
    }
    public Hospede(String numeroDocumento, String nome) {
        super(numeroDocumento, nome);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
