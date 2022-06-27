package org.sofka.app.DukesGN.service.implementation;

import org.sofka.app.DukesGN.dto.ProgramDto;
import org.sofka.app.DukesGN.repository.ProgramRepository;
import org.sofka.app.DukesGN.service.IProgramService;
import org.sofka.app.DukesGN.util.mapper.ProgramMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProgramService implements IProgramService {

    /**
     * Inyecta repositorio de program
     */

    @Autowired
    private ProgramRepository programRepository;

    /**
     * Inyecta el program mapper
     */

    private ProgramMapper programMapper;

    public ProgramService() {
        this.programMapper = new ProgramMapper();
    }

    /**
     * Servicio para crear un program
     *
     * @param programDto
     * @return Mono<ProgramDto>
     */
    @Override
    public Mono<ProgramDto> createProgram(ProgramDto programDto) {
        return programRepository
                .save(programMapper
                        .fromProgramDtoToProgram()
                        .apply(programDto))
                .map(programMapper.fromProgramtoProgramDto());
    }

    /**
     * Servicio para obtener un programa por id
     *
     * @param id_program
     * @return Mono<ProgramDto>
     */

    @Override
    public Mono<ProgramDto> getProgram(String id_program) {
        return programRepository.findById(id_program)
                .map(programMapper.fromProgramtoProgramDto());
    }

    /**
     * Servicio de para obtener un program por id
     *
     * @param id_program
     * @return Mono<Void>
     */

    @Override
    public Mono<String> deleteProgram(String id_program) {
        programRepository.deleteById(id_program);

        return Mono.just("El usuario con el id: " + id_program + " Fue eliminado con EXITO");
    }
}
