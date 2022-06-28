package org.sofka.app.DukesGN.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.sofka.app.DukesGN.dto.ProgramDto;
import org.sofka.app.DukesGN.service.implementation.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebFluxTest(ProgramController.class)
class ProgramControllerTest {

    /**
     * Se inyecta el WebTestClient
     */

    @Autowired
    private WebTestClient webTestClient;

    /**
     * Se inyecta el Servicio de program
     */
    @MockBean
    private ProgramService programService;


    /**
     * Obtener Programa por id
     */

    @Test
    void getProgramById() {
        webTestClient.get().uri("/api/program/get/123")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(ProgramDto.class)
                .getResponseBody();


    }

    /**
     * Test para eliminar un programa
     */

    @Test
    void deleteProgramById() {

        webTestClient.delete().uri("/api/program/delete/123")
                .exchange()
                .expectStatus()
                .isOk();

    }

    /**
     * Test para listar todos los programas
     */

    @Test
    void listAllProgram() {

        webTestClient.get().uri("/api/program/list")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(ProgramDto.class)
                .getResponseBody();
    }
}