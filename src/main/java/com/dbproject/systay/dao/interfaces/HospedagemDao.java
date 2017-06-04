/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.interfaces;

import com.dbproject.systay.beans.Hospedagem;
import java.util.List;

/**
 *
 * @author johny
 */
public interface HospedagemDao {
    Hospedagem getHospedagem(long id);
    Hospedagem cadastrarHospedagem(Hospedagem hospedagem);
    List<Hospedagem> getHospedagens();
    boolean atualizarHospedagem(Hospedagem hospedagem);
    boolean deletarHospedagem(long id);
}
