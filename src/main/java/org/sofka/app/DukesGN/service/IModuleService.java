package org.sofka.app.DukesGN.service;

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
    Mono<ModuleDto> getModule(String id_module);

    /**
     * Listar Módulos del Curso
     * @return Flux<ModuleDto>
     */
    Flux<ModuleDto> listModules();

    /**
     * Actualizar Módulo
     * @param id_module
     * @return Mono<ModuleDto>
     */
    Mono<ModuleDto> updateModule(String id_module, ModuleDto moduleDto);

    /**
     * Eliminar Módulo por Id
     * @param id_module
     * @return Mono<ModuleDto>
     */
    Mono<Void> deleteModule(String id_module);
}
