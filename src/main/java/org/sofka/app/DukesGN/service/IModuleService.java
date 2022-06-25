package org.sofka.app.DukesGN.service;

import org.sofka.app.DukesGN.collection.Module;
import org.sofka.app.DukesGN.dto.ModuleDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IModuleService {

    /**
     * Crear Módulo
     * @param moduleDto
     * @return Mono<ModuleDto>
     */
    Mono<ModuleDto> createModule(ModuleDto moduleDto);

    /**
     * Ver Módulo
     * @param id_module
     * @return Mono<ModuleDto>
     */
    Mono<Module> getModule(String id_module);

    /**
     * Listar Módulos por el Id del Curso
     * @param id_course
     * @return Flux<ModuleDto>
     */
    Flux<ModuleDto> listModules(String id_course);

    /**
     * Actualizar Módulo
     * @param id_module
     * @return Mono<ModuleDto>
     */
    Mono<ModuleDto> updateModule(String id_module);

    /**
     * Eliminar Módulo por Id
     * @param id_module
     * @return Mono<ModuleDto>
     */
    Mono<ModuleDto> deleteModule(String id_module);
}
