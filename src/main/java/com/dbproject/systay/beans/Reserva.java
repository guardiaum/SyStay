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
 * @author Chaina
 */
public class Reserva {
    int id;
    private String observacao;
    private float total_reserva;
    private Date dataCadastro;
    private Date dataEntrada;
    private Date dataSaida;
    private Date dataCancelamento;
    private Administrador responsavelGerencia;
    private Hospede hospede;
    List<Quarto> quarto;

    public Reserva(String observacao, float total_reserva, Date dataCadastro, Date dataEntrada, Date dataSaida, Date dataCancelamento, Administrador responsavelGerencia, Hospede hospede, List<Quarto> quarto) {
        this.observacao = observacao;
        this.total_reserva = total_reserva;
        this.dataCadastro = dataCadastro;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.dataCancelamento = dataCancelamento;
        this.responsavelGerencia = responsavelGerencia;
        this.hospede = hospede;
        this.quarto = quarto;
    }

    public Reserva() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public float getTotal_reserva() {
        return total_reserva;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public Administrador getResponsavelGerencia() {
        return responsavelGerencia;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public List<Quarto> getQuarto() {
        return quarto;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setTotal_reserva(float total_reserva) {
        this.total_reserva = total_reserva;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public void setResponsavelGerencia(Administrador responsavelGerencia) {
        this.responsavelGerencia = responsavelGerencia;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public void setQuarto(List<Quarto> quarto) {
        this.quarto = quarto;
    }
    
}
