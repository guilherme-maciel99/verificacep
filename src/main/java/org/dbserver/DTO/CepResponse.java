/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.dbserver.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CepResponse {
    @JsonProperty("cep")
    private String cepNumero;
    @JsonProperty("logradouro")
    private String endereco;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("localidade")
    private String localidade;
    @JsonProperty("uf")
    private String uf;
    @JsonProperty("ibge")
    private Integer ibge;
    @JsonProperty("ddd")
    private Integer ddd;
}

