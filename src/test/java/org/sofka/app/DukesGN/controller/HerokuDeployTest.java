package org.sofka.app.DukesGN.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@WebFluxTest(HerokuDeploy.class)
class HerokuDeployTest {

    /**
     * Se inyecta el WebTestClient
     */
    @Autowired
    private WebTestClient webTestClient;


    @Test
    void herokuDeploy() {

        webTestClient.get().uri("/api/heroku/deploy")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(String.class);
    }
}