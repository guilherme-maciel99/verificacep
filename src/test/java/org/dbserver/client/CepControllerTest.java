//package org.dbserver.client;
//
//import com.github.tomakehurst.wiremock.WireMockServer;
//import com.github.tomakehurst.wiremock.client.WireMock;
//import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
//import org.dbserver.Controller.CepController;
//import org.dbserver.DTO.CepResponse;
//import org.dbserver.Service.CepService;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static com.github.tomakehurst.wiremock.client.WireMock.*;
//import static org.assertj.core.api.Assertions.assertThat;
//// ...
//
//// ...
//
//@SpringBootTest
//@AutoConfigureWireMock(port = 0) // Escolhe automaticamente uma porta livre
//public class CepControllerTest {
//
//    @MockBean
//    private CepService cepService;
//
//    @Autowired
//    private CepController cepController;
//
//    private static WireMockServer wireMockServer;
//
//    @BeforeAll
//    public static void setup() {
//        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
//        wireMockServer.start();
//        WireMock.configureFor("localhost", wireMockServer.port());
//    }
//
//    @AfterAll
//    public static void tearDown() {
//        wireMockServer.stop();
//    }
//// ...
//
//    @Test
//    public void testBuscarCep() {
//        stubFor(get(urlEqualTo("/cep/94075-370"))
//                .willReturn(aResponse()
//                        .withHeader("Content-Type", "application/json")
//                        .withBody("{\"logradouro\":\"Rua Três Barras\",\"bairro\":\"Parque Florido\"}")));
//
//        ResponseEntity<CepResponse> responseEntity = cepController.buscarCep("94075-370");
//
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        CepResponse cepResponse = responseEntity.getBody();
//        assertThat(cepResponse.getLogradouro()).isEqualTo("Rua Três Barras");
//        assertThat(cepResponse.getBairro()).isEqualTo("Parque Florido");
//
//        verify(getRequestedFor(urlEqualTo("/cep/94075-370")));
//    }
//
//}
