/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.dbserver.Service;


import org.dbserver.DTO.CepRequest;
import org.dbserver.DTO.CepResponse;
import org.dbserver.Handler.CepNaoEncontrado;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepServiceImpl implements CepService{

    @Override
    public CepResponse buscarCEP(String cepNumero) {
        String apiUrl = "https://viacep.com.br/ws/";
        String endpoint = cepNumero+ "/json/";

        RestTemplate restTemplate = new RestTemplate();
        CepResponse cepResponse = restTemplate.getForObject(apiUrl + endpoint, CepResponse.class);

        if (cepResponse == null) {
            throw new CepNaoEncontrado("CEP não encontrado");
        }

        return cepResponse;
    }
    
}
