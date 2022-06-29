package org.sofka.app.DukesGN.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.sofka.app.DukesGN.dto.ModuleDto;
import org.sofka.app.DukesGN.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest(ModuleController.class)
class ModuleControllerTest {

    /**
     * Se inyecta el webTestClient
     */

    @Autowired
    private WebTestClient webTestClient;


    /**
     * Se inyecta el servicio de Module
     */

    @MockBean
    private ModuleService moduleService;

    /**
     * Crear Modulo
     */
    @Test
    void createModule(){
        webTestClient.post().uri("/api/module/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("{}")
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
    }

    /**
     * Test de obtener modulo por id
     */

    @Test
    void getModuleById() {

        webTestClient.get().uri("/api/module/get/2")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(ModuleDto.class)
                .getResponseBody();


    }

    /**
     * Test para listar todos los modulos
     */

    @Test
    void listAllModule() {

        webTestClient.get().uri("/api/module/list")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(ModuleDto.class)
                .getResponseBody();
    }

    /**
     * Test para eliminar un modulo por id
     */

    @Test
    void deleteModuloById() {
        webTestClient.delete().uri("/api/module/delete/2")
                .exchange()
                .expectStatus()
                .isOk();
    }
}