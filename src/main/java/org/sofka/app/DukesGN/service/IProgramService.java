package org.sofka.app.DukesGN.service;


import org.sofka.app.DukesGN.collection.Program;
import reactor.core.publisher.Mono;

public interface IProgramService {

    /**
     * Crear Programa
     *
     * @param program
     * @return Mono<Program>
     */
    Mono<Program> createCourse(Program program);

    /**
     * Mostrar Programa por Id
     *
     * @param id_program
     * @return Mono<Program>
     */
    Mono<Program> getProgram(String id_program);

    /**
     * Eliminar un Programa por Id
     *
     * @param id_program
     * @return Mono<Program>
     */
    Mono<Program> deleteProgram(String id_program);
}
