package org.sofka.app.DukesGN.service.impletation;

import org.sofka.app.DukesGN.dto.ProgramDto;
import org.sofka.app.DukesGN.repository.ProgramRepository;
import org.sofka.app.DukesGN.service.IProgramService;
import org.sofka.app.DukesGN.util.mapper.ProgramMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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
        programDto.setFinal_date(programDto.getStart_date().plusDays(programDto.getDuration_day()));
        programDto.setCourse_percentage(100/programDto.getCourse_amount());
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
    public Mono<Void> deleteProgram(String id_program) {


        return programRepository.deleteById(id_program);
    }

    /**
     * Servicio para listar todos los program
     *
     * @return Flux<ProgramDto>
     */

    @Override
    public Flux<ProgramDto> listAllProgram() {
        return programRepository
                .findAll()
                .map(program -> programMapper
                        .fromProgramtoProgramDto()
                        .apply(program));
    }

    /**
     * Servicio para guardar una lista de program
     *
     * @param listProgram
     * @return
     */

    @Override
    public Flux<List<ProgramDto>> saveAllProgram(List<ProgramDto> listProgram) {
        return programRepository.saveAll(listProgram);
    }
}
