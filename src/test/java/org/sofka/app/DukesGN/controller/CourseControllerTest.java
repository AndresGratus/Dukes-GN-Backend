package org.sofka.app.DukesGN.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.sofka.app.DukesGN.dto.CourseDto;
import org.sofka.app.DukesGN.service.impletation.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest(CourseController.class)
class CourseControllerTest {

    /**
     * Inyección de WebTestClient
     */

    @Autowired
    private WebTestClient webTestClient;

    /**
     * Inyeccion del servicio de course
     */

    @MockBean
    private CourseService courseService;


    /**
     *  Test de obtener course por id
     */


    @Test
    void getCoursebyId() {

        webTestClient.get().uri("/api/course/get/2")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(CourseDto.class)
                .getResponseBody();

    }

    /**
     * Test de eliminar un course por id
     */

    @Test
    void deleteCourse() {
        webTestClient.delete().uri("/api/course/delete/2")
                .exchange()
                .expectStatus()
                .isOk();
    }
}