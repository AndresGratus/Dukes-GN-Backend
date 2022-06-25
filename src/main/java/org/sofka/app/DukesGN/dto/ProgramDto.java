package org.sofka.app.DukesGN.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sofka.app.DukesGN.util.exception.ValidateArgument;
import org.sofka.app.DukesGN.util.message.Messages;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class ProgramDto {

    private String id_program;

    private String name;

    private LocalDateTime start_date;

    private LocalDateTime final_date;

    private String id_coach;

    private String name_coach;

    private ArrayList<String> course;

    private ArrayList<String> apprentice;

    public ProgramDto(String id_program, String name, LocalDateTime start_date, LocalDateTime final_date, String id_coach, String name_coach, ArrayList<String> course, ArrayList<String> apprentice) {
        ValidateArgument.validateStringNull(this.id_program, Messages.ID_PROGRAMA_NULO);
        this.id_program = id_program;

        ValidateArgument.validateStringNull(this.name,Messages.NOMBRE_PROGRAMA_VACIO);
        this.name = name;

        this.start_date = start_date;
        this.final_date = final_date;

        ValidateArgument.validateStringNull(this.id_coach,Messages.ID_COACH_NULO);
        this.id_coach = id_coach;

        ValidateArgument.validateStringNull(this.name_coach,Messages.NOMBRE_COACH_VACIO);
        this.name_coach = name_coach;

        this.course = course;
        this.apprentice = apprentice;
    }
}
