package org.dbserver.e2e;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.dbserver.DTO.CepResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AssuredTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup(){
        RestAssured.port = this.port;
    }

    @Test
    public void testBuscarCep() {
        given()
                .header("", "")
                .contentType(ContentType.JSON)
                .when()
                .get("/cep/94075370")
                .then()
                .statusCode(200)
                .body("logradouro", equalTo("Rua Três Barras"))
                .body("bairro", equalTo("Parque Florido"));
    }
}
