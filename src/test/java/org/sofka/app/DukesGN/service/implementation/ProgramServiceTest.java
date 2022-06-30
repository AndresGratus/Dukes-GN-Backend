package org.sofka.app.DukesGN.service.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sofka.app.DukesGN.collection.Program;
import org.sofka.app.DukesGN.dto.ProgramDto;
import org.sofka.app.DukesGN.util.mapper.ProgramMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProgramServiceTest {

    /**
     * Se inyecta el Servicio de programa
     */
    @Autowired
    ProgramService programService;

    /**
     * Se instancia el Mapper de Programa
     */
    ProgramMapper programMapper = new ProgramMapper();

    @BeforeEach
    void setUp() {
        programService = mock(ProgramService.class);
    }

    /**
     * Crear Programa
     */
    @Test
    void createProgram() {

        var program = new Program();
        program.setId_program("P-0001");
        program.setName("Desarrollo de Software");
        program.setStart_date(LocalDate.now());
        program.setFinal_date(LocalDate.of(2022, 07, 15));
        program.setId_coach("C-0001");
        program.setName_coach("Julián Lasso");
        program.setDuration_day(15L);
        program.setCourse_amount(4D);
        program.setCourse_percentage(25D);

        var programDto = programMapper.fromProgramtoProgramDto().apply(program);

        when(programService.createProgram(programDto))
                .thenReturn(Mono.just(programDto));

        StepVerifier.create(programService.createProgram(programDto))
                .expectSubscription()
                .expectNext(programDto)
                .verifyComplete();

        verify(programService).createProgram(programDto);
    }

    /**
     * Obtener Programa por id
     */
    @Test
    void getProgram() {

        var program = new Program();
        program.setId_program("P-0001");
        program.setName("Desarrollo de Software");
        program.setStart_date(LocalDate.now());
        program.setFinal_date(LocalDate.of(2022, 07, 15));
        program.setId_coach("C-0001");
        program.setName_coach("Julián Lasso");
        program.setDuration_day(15L);
        program.setCourse_amount(4D);
        program.setCourse_percentage(25D);

        var programDto = programMapper.fromProgramtoProgramDto().apply(program);

        when(programService.getProgram(programDto.getId_program()))
                .thenReturn(Mono.just(programDto));

        StepVerifier.create(programService.getProgram(programDto.getId_program()))
                .expectSubscription()
                .expectNext(programDto)
                .verifyComplete();

        verify(programService).getProgram(programDto.getId_program());
    }
    /**
     * Test para eliminar un programa
     */
    @Test
    void deleteProgram() {

        var program = new Program();
        program.setId_program("P-0001");
        program.setName("Desarrollo de Software");
        program.setStart_date(LocalDate.now());
        program.setFinal_date(LocalDate.of(2022, 07, 15));
        program.setId_coach("C-0001");
        program.setName_coach("Julián Lasso");
        program.setDuration_day(15L);
        program.setCourse_amount(4D);
        program.setCourse_percentage(25D);

        var programDto = programMapper.fromProgramtoProgramDto().apply(program);

        when(programService.deleteProgram(programDto.getId_program()))
                .thenReturn(Mono.empty());

        StepVerifier.create(programService.deleteProgram(programDto.getId_program()))
                .expectSubscription()
                .expectNext()
                .verifyComplete();

        verify(programService).deleteProgram(programDto.getId_program());
    }

    /**
     * Test para listar todos los programas
     */
    @Test
    void listAllProgram() {

        var program = new Program();
        program.setId_program("P-0001");
        program.setName("Desarrollo de Software");
        program.setStart_date(LocalDate.now());
        program.setFinal_date(LocalDate.of(2022, 07, 15));
        program.setId_coach("C-0001");
        program.setName_coach("Julián Lasso");
        program.setDuration_day(15L);
        program.setCourse_amount(4D);
        program.setCourse_percentage(25D);

        var programDto = programMapper.fromProgramtoProgramDto().apply(program);

        when(programService.listAllProgram()).thenReturn(Flux.just());

        StepVerifier.create(programService.listAllProgram())
                .expectSubscription()
                .expectNextMatches( p -> {
                    assert p.getName().equals(program.getName());
                    return true;
                })
                .expectComplete();

        verify(programService).listAllProgram();
    }

    /**
     * Test para guardar todos los programas
     */
    @Test
    void saveAllProgram() {

        var program1 = new Program();
        program1.setId_program("P-0001");
        program1.setName("Desarrollo de Software");
        program1.setStart_date(LocalDate.now());
        program1.setFinal_date(LocalDate.of(2022, 07, 15));
        program1.setId_coach("C-0001");
        program1.setName_coach("Julián Lasso");
        program1.setDuration_day(15L);
        program1.setCourse_amount(4D);
        program1.setCourse_percentage(25D);

        var program1Dto = programMapper.fromProgramtoProgramDto().apply(program1);

        var program2 = new Program();
        program2.setId_program("P-0001");
        program2.setName("Desarrollo de Software");
        program2.setStart_date(LocalDate.now());
        program2.setFinal_date(LocalDate.of(2022, 07, 15));
        program2.setId_coach("C-0001");
        program2.setName_coach("Julián Lasso");
        program2.setDuration_day(15L);
        program2.setCourse_amount(4D);
        program2.setCourse_percentage(25D);

        var program2Dto = programMapper.fromProgramtoProgramDto().apply(program2);

        var listProgramsDto = List.of(program1Dto, program2Dto);

        when(programService.saveAllProgram(listProgramsDto))
                .thenReturn(Flux.just(listProgramsDto));

        StepVerifier.create(programService.saveAllProgram(listProgramsDto))
                .expectSubscription()
                .expectNext(listProgramsDto)
                .verifyComplete();

        verify(programService).saveAllProgram(listProgramsDto);
    }
}