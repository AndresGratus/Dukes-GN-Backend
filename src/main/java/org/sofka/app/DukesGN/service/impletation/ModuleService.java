package org.sofka.app.DukesGN.service.impletation;

import org.sofka.app.DukesGN.dto.ModuleDto;
import org.sofka.app.DukesGN.repository.ModuleRepository;
import org.sofka.app.DukesGN.service.IModuleService;
import org.sofka.app.DukesGN.util.mapper.ModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ModuleService implements IModuleService {

    /**
     * Se inyecta el repositorio de de module
     */
    @Autowired
    private ModuleRepository moduleRepository;


    /**
     * Se inyecta el module mapper
     */

    private ModuleMapper moduleMapper;

    public ModuleService() {
        this.moduleMapper = new ModuleMapper();
    }

    /**
     * Servicio para crear un module
     *
     * @param moduleDto
     * @return Mono<ModuleDto>
     */
    @Override
    public Mono<ModuleDto> createModule(ModuleDto moduleDto) {
        return moduleRepository
                .save(moduleMapper
                        .fromModuleDtoToModule()
                        .apply(moduleDto))
                .map(moduleMapper.fromModuleToModuleDto());
    }

    /**
     * Service para obtener un module
     *
     * @param id_module
     * @return Mono<Module>
     */
    @Override
    public Mono<ModuleDto> getModule(String id_module) {
        return moduleRepository
                .findById(id_module)
                .map(moduleMapper
                        .fromModuleToModuleDto());
    }

    /**
     * Servicio para listar los course
     *
     * @return Flux<ModuleDto>
     */

    @Override
    public Flux<ModuleDto> listModules() {
        return moduleRepository
                .findAll()
                .map(module -> moduleMapper.fromModuleToModuleDto().apply(module));
    }

    /**
     * Servicio para actualizar un module por el id
     *
     * @param id_module
     * @param moduleDto
     * @return Mono<ModuleDto>
     */
    @Override
    public Mono<ModuleDto> updateModule(String id_module, ModuleDto moduleDto) {
        Mono<ModuleDto> moduleMono = moduleRepository.findById(id_module)
                .map(module -> {
                    module.setName(moduleDto.getName());
                    module.setPercentage(moduleDto.getPercentage());
                    module.setScore(moduleDto.getScore());
                    moduleRepository.save(module);
                    return module;
                }).map(moduleMapper.fromModuleToModuleDto());


        return moduleMono;
    }

    /**
     * Servicio para eliminar un module por id
     *
     * @param id_module
     * @return Mono<Void>
     */

    @Override
    public Mono<Void> deleteModule(String id_module) {
        return moduleRepository.deleteById(id_module);
    }


    /**
     * Servicio para guardar una lista de module
     * @param moduleDtoList
     * @return
     */

    @Override
    public Flux<List<ModuleDto>> saveAllModule(List<ModuleDto> moduleDtoList) {
        return moduleRepository.saveAll(moduleDtoList);
    }
}
