/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.interfaces;

import com.dbproject.systay.beans.Hospede;
import java.util.List;

/**
 *
 * @author Chaina
 */
public interface HospedeService {
    int save (Hospede hospede);
    int update(Hospede hospede);
    int delete(String numeroDocumento);
    List<Hospede> getHospedes();
    Hospede getHospedeById(String numeroDocumento);
}
