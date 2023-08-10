
package org.dbserver.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CEP {
    Integer cepNumero;
    String endereco;
    String complemento;
    String bairro;
    String localidade;
    char[] UF = new char[2];
    Integer ibge;
    Integer ddd;
    
    
}
