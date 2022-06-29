package org.sofka.app.DukesGN.util.mapper;

import org.sofka.app.DukesGN.dto.ModuleDto;
import org.sofka.app.DukesGN.collection.Module;

import java.util.function.Function;

public class ModuleMapper {

    /**
     * Método que nos permite transformar la colección Modulo a su equivalente en Dto
     *
     * @return ModuleDto
     */

    public Function<Module, ModuleDto> fromModuleToModuleDto() {
        return module -> {
            ModuleDto moduleDto = new ModuleDto();
            moduleDto.setId_module(module.getId_module());
            moduleDto.setId_course(module.getId_course());
            moduleDto.setName(module.getName());
            moduleDto.setScore(module.getScore());
            moduleDto.setPercentage(module.getPercentage());
            moduleDto.setDuration(module.getDuration());
            return moduleDto;
        };
    }

    /**
     * Método que nos permite transformar el Dto Modulo a su equivalente en la Colección
     *
     * @return Module
     */
    public Function<ModuleDto, Module> fromModuleDtoToModule() {
        return moduleDto -> {
            Module module = new Module();
            module.setId_module(moduleDto.getId_module());
            module.setId_course(moduleDto.getId_course());
            module.setName(moduleDto.getName());
            module.setScore(moduleDto.getScore());
            module.setPercentage(moduleDto.getPercentage());
            module.setDuration(moduleDto.getDuration());
            return module;
        };
    }

}
