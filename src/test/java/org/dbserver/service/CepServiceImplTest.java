package org.dbserver.service;

import org.dbserver.DTO.CepResponse;
import org.dbserver.Handler.CepNaoEncontrado;
import org.dbserver.Service.CepServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CepServiceImplTest {

        @Mock
        private RestTemplate restTemplate;

        @InjectMocks
        private CepServiceImpl cepService;

        private String cepNumero = "12345678";

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testBuscarCEPEncontrado() {
            CepResponse cepResponseMock = new CepResponse();
            when(restTemplate.getForObject(anyString(), eq(CepResponse.class))).thenReturn(cepResponseMock);
            CepResponse result = cepService.buscarCEP(cepNumero);
            assertNotNull(result);
        }

        @Test
        public void testBuscarCEPNaoEncontrado() {
            when(restTemplate.getForObject(anyString(), eq(CepResponse.class))).thenReturn(null);
            assertThrows(CepNaoEncontrado.class, () -> {
                cepService.buscarCEP(cepNumero);
            });
        }
    }


