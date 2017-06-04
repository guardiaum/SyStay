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
public class QuartoComum extends Quarto{
    
    private int qtd_camas;
    private String tipo_camas;

    public QuartoComum() {
    }

    public QuartoComum(int id, int numero, String observacao, Image fotos, double area, char tem_varanda, String ramal, float valor_diaria, Administrador responsavelGerencia) {
        super(id, numero, observacao, fotos, area, tem_varanda, ramal, valor_diaria, responsavelGerencia);
    }
    
    public QuartoComum(int qtd_camas, String tipo_camas, int id, int numero, String observacao, Image fotos, double area, char tem_varanda, String ramal, float valor_diaria, Administrador responsavelGerencia) {
        super(id, numero, observacao, fotos, area, tem_varanda, ramal, valor_diaria, responsavelGerencia);
        this.qtd_camas = qtd_camas;
        this.tipo_camas = tipo_camas;
    }
    
    public int getQtd_camas() {
        return qtd_camas;
    }

    public void setQtd_camas(int qtd_camas) {
        this.qtd_camas = qtd_camas;
    }

    public String getTipo_camas() {
        return tipo_camas;
    }

    public void setTipo_camas(String tipo_camas) {
        this.tipo_camas = tipo_camas;
    }
    
}
