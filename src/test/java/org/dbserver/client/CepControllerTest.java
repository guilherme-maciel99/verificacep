package org.dbserver.client;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.Options;
import org.dbserver.CepController;
import org.dbserver.Service.CepService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureWireMock(port = Options.DYNAMIC_PORT)
@WebMvcTest(CepController.class)
@AutoConfigureMockMvc
public class CepControllerTest {
    @MockBean
    private CepService cepService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testBuscarCep() throws Exception {
        WireMock.stubFor(get(urlEqualTo("/cep/12345678"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"logradouro\":\"Rua Exemplo\",\"bairro\":\"Bairro Exemplo\"}")));
        mockMvc.perform((RequestBuilder) get("/cep/12345678"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.logradouro").value("Rua Exemplo"))
                .andExpect(jsonPath("$.bairro").value("Bairro Exemplo"));
        verify(getRequestedFor(urlEqualTo("/cep/12345678")));
    }
}
