package org.dbserver.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class CepResponse {
    @JsonProperty("cep")
    private String cepNumero;
    @JsonProperty("logradouro")
    private String logradouro;
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


