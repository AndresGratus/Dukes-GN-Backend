package org.sofka.app.DukesGN.service;

import org.sofka.app.DukesGN.dto.ProgramDto;
import reactor.core.publisher.Mono;

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
    Mono<String> deleteProgram(String id_program);
}
