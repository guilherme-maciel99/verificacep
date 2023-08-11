package org.dbserver;
import org.dbserver.DTO.CepResponse;
import org.dbserver.Service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cep")
public class CepController {

    private final CepService cepService;

    @Autowired
    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cepNumero}")
    public ResponseEntity<CepResponse> buscarCep(@PathVariable String cepNumero) {
        CepResponse cepResponse = cepService.buscarCEP(cepNumero);
        return ResponseEntity.ok(cepResponse);
    }
}
