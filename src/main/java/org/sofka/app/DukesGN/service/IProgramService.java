package org.sofka.app.DukesGN.service;

import org.sofka.app.DukesGN.dto.ProgramDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IProgramService {

    /**
     * Crear Programa
     *
     * @param programDto
     * @return Mono<ProgramDto>
     */
    Mono<ProgramDto> createProgram(ProgramDto programDto);

    /**
     * Mostrar Programa por Id
     *
     * @param id_program
     * @return Mono<ProgramDto>
     */
    Mono<ProgramDto> getProgram(String id_program);

    /**
     * Eliminar un Programa por Id
     *
     * @param id_program
     * @return Mono<ProgramDto>
     */
    Mono<Void> deleteProgram(String id_program);

    /**
     * List todos los programas
     *
     * @return Flux<ProgramDto>
     */
    Flux<ProgramDto> listAllProgram();

    /**
     * Guadar una lista de programas
     * @param listProgram
     * @return Flux<List<ProgramDto>>
     */
    Flux<List<ProgramDto>> saveAllProgram(List<ProgramDto> listProgram);


}
