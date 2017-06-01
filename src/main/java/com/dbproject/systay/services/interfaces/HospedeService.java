/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.services.interfaces;

import com.dbproject.systay.beans.Hospede;

/**
 *
 * @author Chaina
 */
public interface HospedeService {
    int save (Hospede hospede);
    int update(Hospede hospede);
    int delete(String numeroDocumento);
}
