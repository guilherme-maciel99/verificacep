
package org.dbserver.Service;
import org.dbserver.DTO.CepResponse;
import org.dbserver.Handler.CepNaoEncontrado;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepServiceImpl implements CepService{

    private RestTemplate restTemplate;

    public CepServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CepResponse buscarCEP(String cepNumero) {
        String apiUrl = "https://viacep.com.br/ws/";
        String endpoint = cepNumero + "/json/";
        CepResponse cepResponse = restTemplate.getForObject(apiUrl + endpoint, CepResponse.class);

        if (cepResponse == null) {
            throw new CepNaoEncontrado("CEP não encontrado");
        }

        return cepResponse;
    }

}
