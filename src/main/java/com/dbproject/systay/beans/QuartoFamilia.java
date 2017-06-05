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
public class QuartoFamilia extends Quarto{
    
    private int qtd_camas_adicionais;
    
    public QuartoFamilia() {
    }

    public QuartoFamilia(int id, int numero, String observacao, Image fotos, double area, char tem_varanda, String ramal, float valor_diaria, Administrador responsavelGerencia) {
        super(id, numero, observacao, fotos, area, tem_varanda, ramal, valor_diaria, responsavelGerencia);
    }
    
    public QuartoFamilia(int qtd_camas_adicionais, int id, int numero, String observacao, Image fotos, double area, char tem_varanda, String ramal, float valor_diaria, Administrador responsavelGerencia) {
        super(id, numero, observacao, fotos, area, tem_varanda, ramal, valor_diaria, responsavelGerencia);
        this.qtd_camas_adicionais = qtd_camas_adicionais;
    }
    
    public int getQtd_camas_adicionais() {
        return qtd_camas_adicionais;
    }

    public void setQtd_camas_adicionais(int qtd_camas_adicionais) {
        this.qtd_camas_adicionais = qtd_camas_adicionais;
    }
    
}
