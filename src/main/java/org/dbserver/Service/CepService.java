/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.dbserver.Service;


import org.dbserver.DTO.CepResponse;

public interface CepService {
    CepResponse buscarCEP(String cepNumero);
    
}
