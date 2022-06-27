package org.sofka.app.DukesGN.controller;

import org.sofka.app.DukesGN.dto.ProgramDto;
import org.sofka.app.DukesGN.service.implementation.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/program")
public class ProgramController {

    /**
     * Se inyecta el servicio de program
     */

    @Autowired
    private ProgramService programService;


    /**
     * Endpoint para crear un programa
     *
     * @param programDto
     * @return Mono<ResponseEntity < Mono < ProgramDto>>>
     */


    @PostMapping("/create")
    public Mono<ResponseEntity<Mono<ProgramDto>>> createProgram(@RequestBody ProgramDto programDto) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(programService.createProgram(programDto))
            );

        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear el Programa");
        }

    }

    /**
     * Endpoint para obtener un programa por id
     *
     * @param program_id
     * @return Mono<ResponseEntity < Mono < ProgramDto>>>
     */

    @GetMapping("/get/{program_id}")
    public Mono<ResponseEntity<Mono<ProgramDto>>> getProgramById(@PathVariable("program_id") String program_id) {

        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(programService.getProgram(program_id))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener el programa por el id");
        }

    }

    /**
     * Endpoint para eliminar un program por id
     *
     * @param program_id
     * @return Mono<ResponseEntity < Mono < String>>>
     */

    @DeleteMapping("/delete/{program_id}")
    public Mono<ResponseEntity<Mono<String>>> deleteProgramById(@PathVariable("program_id") String program_id) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .body(programService.deleteProgram(program_id))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo eliminar el programa");
        }

    }


}
