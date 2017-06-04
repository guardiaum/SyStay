/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.beans;

import java.awt.Image;

/**
 *
 * @author araujomarianna
 */
public class Quarto {
    private int id;
    private int numero;
    private String observacao ;
    private Image fotos;
    private double area;
    private char tem_varanda;
    private String ramal;
    private float valor_diaria;
    private Administrador responsavelGerencia;
    
    public  Quarto(){
        
    }

    public Quarto(int id, double area, float valor_diaria) {
        this.id = id;
        this.area = area;
        this.valor_diaria = valor_diaria;
    }
    
    public Quarto(int id, int numero, String observacao, Image fotos, double area, char tem_varanda, String ramal, float valor_diaria, Administrador responsavelGerencia) {
        this.id = id;
        this.numero = numero;
        this.observacao = observacao;
        this.fotos = fotos;
        this.area = area;
        this.tem_varanda = tem_varanda;
        this.ramal = ramal;
        this.valor_diaria = valor_diaria;
        this.responsavelGerencia = responsavelGerencia;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Image getFotos() {
        return fotos;
    }

    public void setFotos(Image fotos) {
        this.fotos = fotos;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setTem_varanda(char tem_varanda) {
        this.tem_varanda = tem_varanda;
    }
    
     public char getTem_varanda() {
        return this.tem_varanda;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public float getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(float valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    public Administrador getResponsavelGerencia() {
        return responsavelGerencia;
    }

    public void setResponsavelGerencia(Administrador responsavelGerencia) {
        this.responsavelGerencia = responsavelGerencia;
    }
    
    
}
