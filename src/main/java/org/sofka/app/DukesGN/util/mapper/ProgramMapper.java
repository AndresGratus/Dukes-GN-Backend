package org.sofka.app.DukesGN.util.mapper;

import org.sofka.app.DukesGN.collection.Program;
import org.sofka.app.DukesGN.dto.ProgramDto;

import java.util.function.Function;

public class ProgramMapper {
    /**
     * Metodo que nos permite tranformar la colección programa a su equivalente en Dto.
     * @return ProgramDto
     */

    public Function<Program, ProgramDto> fromProgramtoProgramDto(){
        return program -> {
            ProgramDto programDto = new ProgramDto();
            programDto.setId_program(program.getId_program());
            programDto.setName(program.getName());
            programDto.setStart_date(program.getStart_date());
            programDto.setFinal_date(program.getFinal_date());
            programDto.setId_coach(program.getId_coach());
            programDto.setName_coach(program.getName_coach());

            return programDto;
        };

    }

    /**
     * Metodo que nos permite tranformar eñ Dto programa a su equivalente en la Colección.
     *
     * @return Program
     */

    public Function<ProgramDto, Program> fromProgramDtoToProgram(){
        return programDto -> {
            Program program = new Program();
            program.setId_program(programDto.getId_program());
            program.setName(programDto.getName());
            program.setStart_date(programDto.getStart_date());
            program.setFinal_date(programDto.getFinal_date());
            program.setId_coach(programDto.getId_coach());
            program.setName_coach(programDto.getName_coach());

            return program;
        };
    }
}
