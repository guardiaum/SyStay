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
public class Pessoa {
    private String numeroDocumento;
    private String nome;
    private Endereco endereco;
    private Date data_nascimento;
    private List<Telefone> telefone;

    public Pessoa() {
    }

    public Pessoa(String numeroDocumento, String nome, Date data_nascimento) {
        this.numeroDocumento = numeroDocumento;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public Pessoa(String numeroDocumento, String nome, Endereco endereco, Date data_nascimento, List<Telefone> telefone) {
        this.numeroDocumento = numeroDocumento;
        this.nome = nome;
        this.endereco = endereco;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
    }

    public Pessoa(String numeroDocumento, String nome) {
        this.numeroDocumento = numeroDocumento;
        this.nome = nome;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }
    
}
