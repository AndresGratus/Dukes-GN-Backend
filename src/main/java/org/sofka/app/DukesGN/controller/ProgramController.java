package org.sofka.app.DukesGN.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.sofka.app.DukesGN.dto.ProgramDto;
import org.sofka.app.DukesGN.service.implementation.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

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

    @Operation(summary = " --> Endpoint que nos permite crear un programa")
    @ApiResponse(responseCode = "200", description = "Se guardo el programa")
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

    @Operation(summary = " --> Endpoint que nos permite obtener el programa por el id")
    @ApiResponse(responseCode = "200", description = "Se obtuvo el programa por el id")
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

    @Operation(summary = " --> Endpoint que nos permite eliminar un programa por id")
    @ApiResponse(responseCode = "200", description = "Se elimino el programa por id")
    @DeleteMapping("/delete/{program_id}")
    public Mono<ResponseEntity<Mono<Void>>> deleteProgramById(@PathVariable("program_id") String program_id) {
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


    /**
     * Endpoint para listar todos los programas
     *
     * @return Mono<ResponseEntity < Flux < ProgramDto>>>
     */

    @Operation(summary = " --> Endpoint que nos permite listar todos los programas")
    @ApiResponse(responseCode = "200", description = "Se listaron todos los programas")
    @GetMapping("/list")
    public Mono<ResponseEntity<Flux<ProgramDto>>> listAllProgram() {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(programService.listAllProgram())
            );
        } catch (Exception e) {
            throw new RuntimeException("No se puede listar todos los programas");
        }
    }

    /**
     * @param programDtos
     * @return
     */

    @Operation(summary = " --> Endpoint que nos permite guardar una lista de programas")
    @ApiResponse(responseCode = "200", description = "Se guardo la lista de programas")
    @PostMapping("/saveAll")
    public Mono<ResponseEntity<Flux<List<ProgramDto>>>> saveAllProgram(@RequestBody List<ProgramDto> programDtos) {

        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(programService.saveAllProgram(programDtos))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar la lista de Program");
        }

    }

    @Operation(summary = " --> Endpoint que nos permite obtener un programa por el id del coach")
    @ApiResponse(responseCode = "200", description = "Se obtuvo el programa por el id del coach")
    @GetMapping("/coach/{id_coach}")
    public Mono<ResponseEntity<Flux<ProgramDto>>> getProgramByIdCoach(@PathVariable("id_coach") String id_coach) {

        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(programService
                                    .listAllProgram()
                                    .filter(programDto -> Objects.equals(programDto.getId_coach(), id_coach)))

            );

        } catch (Exception e) {
            throw new RuntimeException("No se pudo listar los programas por el id del coach");

        }

    }


}
