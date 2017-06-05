/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.beans;

import java.util.Date;

/**
 *
 * @author johny
 */
public class Hospedagem {
    private int id;
    private double resto_reserva;
    private Date dataCheckin;
    private Date dataCheckout;
    private Administrador responsavel;
    private Reserva reserva;
    
    public Hospedagem() {
    }

    public Hospedagem(int id, double resto_reserva, Date dataCheckin, Date dataCheckout, Administrador responsavel, Reserva reserva) {
        this.id = id;
        this.resto_reserva = resto_reserva;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.responsavel = responsavel;
        this.reserva = reserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getResto_reserva() {
        return resto_reserva;
    }

    public void setResto_reserva(double resto_reserva) {
        this.resto_reserva = resto_reserva;
    }

    public Date getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public Date getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(Date dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public Administrador getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Administrador responsavel) {
        this.responsavel = responsavel;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
}