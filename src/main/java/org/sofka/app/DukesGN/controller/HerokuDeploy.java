package org.sofka.app.DukesGN.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/heroku")
public class HerokuDeploy {

    @GetMapping("/deploy")
    public ResponseEntity<Mono<String>> herokuDeploy() {
        return ResponseEntity.
                ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("---> Backend Desplegado <---"));
    }
}
