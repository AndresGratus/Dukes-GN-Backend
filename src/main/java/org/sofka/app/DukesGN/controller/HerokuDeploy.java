package org.sofka.app.DukesGN.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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


    @Operation(summary = " --> Endpoint que nos permite ver el backen desplegado")
    @ApiResponse(responseCode = "200", description = "Backend desplegado")
    @GetMapping("/deploy")
    public ResponseEntity<Mono<String>> herokuDeploy() {
        return ResponseEntity.
                ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("---> Backend Desplegado <---"));
    }
}
