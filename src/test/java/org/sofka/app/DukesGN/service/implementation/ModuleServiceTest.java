package org.sofka.app.DukesGN.service.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sofka.app.DukesGN.collection.Module;
import org.sofka.app.DukesGN.dto.ModuleDto;
import org.sofka.app.DukesGN.util.mapper.CourseMapper;
import org.sofka.app.DukesGN.util.mapper.ModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ModuleServiceTest {


    @Autowired
    ModuleService moduleService;

    ModuleMapper moduleMapper = new ModuleMapper();

    @BeforeEach
    void setUp() {
        moduleService = mock(ModuleService.class);
    }

    @Test
    void createModule() {

        var module = new Module();
        module.setId_module("M-0001");
        module.setId_course("C-0001");
        module.setName("Módulo 1");
        module.setScore(99D);
        module.setPercentage(25D);
        module.setDuration(15L);

        var moduleDto = moduleMapper.fromModuleToModuleDto().apply(module);

        when(moduleService.createModule(moduleDto))
                .thenReturn(Mono.just(moduleDto));

        StepVerifier.create(moduleService.createModule(moduleDto))
                .expectSubscription()
                .expectNext(moduleDto)
                .verifyComplete();

        verify(moduleService).createModule(moduleDto);
    }

    @Test
    void getModule() {

        var module = new Module();
        module.setId_module("M-0001");
        module.setId_course("C-0001");
        module.setName("Módulo 1");
        module.setScore(99D);
        module.setPercentage(25D);
        module.setDuration(15L);

        var moduleDto = moduleMapper.fromModuleToModuleDto().apply(module);

        when(moduleService.getModule(moduleDto.getId_module()))
                .thenReturn(Mono.just(moduleDto));

        StepVerifier.create(moduleService.getModule(moduleDto.getId_module()))
                .expectSubscription()
                .expectNextMatches( m -> {
                    assert m.getId_module().equals(moduleDto.getId_module());
                    return true;
                })
                .verifyComplete();

        verify(moduleService).getModule(moduleDto.getId_module());
    }

    @Test
    void listModules() {

        var module = new Module();
        module.setId_module("M-0001");
        module.setId_course("C-0001");
        module.setName("Módulo 1");
        module.setScore(99D);
        module.setPercentage(25D);
        module.setDuration(15L);

        var moduleDto = moduleMapper.fromModuleToModuleDto().apply(module);

        when(moduleService.listModules()).thenReturn(Flux.just(moduleDto));

        StepVerifier.create(moduleService.listModules())
                .expectSubscription()
                .expectNext(moduleDto)
                .verifyComplete();

        verify(moduleService).listModules();
    }

    @Test
    void updateModule() {

        var module = new Module();
        module.setId_module("M-0001");
        module.setId_course("C-0001");
        module.setName("Módulo 1");
        module.setScore(99D);
        module.setPercentage(25D);
        module.setDuration(15L);

        var moduleDto = new ModuleDto();
        moduleDto.setId_module(module.getId_module());
        moduleDto.setId_course(module.getId_course());
        moduleDto.setName(module.getName());
        moduleDto.setScore(85D);
        moduleDto.setPercentage(20D);
        moduleDto.setDuration(module.getDuration());

        when(moduleService.updateModule(moduleDto.getId_module(), moduleDto))
                .thenReturn(Mono.just(moduleDto));

        StepVerifier.create(moduleService.updateModule(moduleDto.getId_module(), moduleDto))
                .expectSubscription()
                .expectNextMatches( m -> {
                    assert m.getScore().equals(85D);
                    return true;
                })
                .verifyComplete();

        verify(moduleService).updateModule(moduleDto.getId_module(), moduleDto);
    }

    @Test
    void deleteModule() {

        var module = new Module();
        module.setId_module("M-0001");
        module.setId_course("C-0001");
        module.setName("Módulo 1");
        module.setScore(99D);
        module.setPercentage(25D);
        module.setDuration(15L);

        var moduleDto = moduleMapper.fromModuleToModuleDto().apply(module);

        when(moduleService.deleteModule(moduleDto.getId_module()))
                .thenReturn(Mono.empty());

        StepVerifier.create(moduleService.deleteModule(moduleDto.getId_module()))
                .expectSubscription()
                .expectNext()
                .verifyComplete();

        verify(moduleService).deleteModule(moduleDto.getId_module());
    }

    @Test
    void saveAllModule() {

        var module1 = new Module();
        module1.setId_module("M-0001");
        module1.setId_course("C-0001");
        module1.setName("Módulo 1");
        module1.setScore(99D);
        module1.setPercentage(25D);
        module1.setDuration(15L);

        var module1Dto = moduleMapper.fromModuleToModuleDto().apply(module1);

        var module2 = new Module();
        module2.setId_module("M-0001");
        module2.setId_course("C-0001");
        module2.setName("Módulo 1");
        module2.setScore(99D);
        module2.setPercentage(25D);
        module2.setDuration(15L);

        var module2Dto = moduleMapper.fromModuleToModuleDto().apply(module2);

        var listModulesDto = List.of(module1Dto, module2Dto);

        when(moduleService.saveAllModule(listModulesDto))
                .thenReturn(Flux.just(listModulesDto));

        StepVerifier.create(moduleService.saveAllModule(listModulesDto))
                .expectSubscription()
                .expectNext(listModulesDto)
                .verifyComplete();

        verify(moduleService).saveAllModule(listModulesDto);
    }
}