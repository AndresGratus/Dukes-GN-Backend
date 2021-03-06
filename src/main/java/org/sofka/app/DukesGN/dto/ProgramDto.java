package org.sofka.app.DukesGN.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sofka.app.DukesGN.util.exception.ValidateArgument;
import org.sofka.app.DukesGN.util.message.Messages;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class ProgramDto {

    private String id_program;

    private String name;

    private LocalDate start_date = LocalDate.now();

    private LocalDate final_date;

    private String id_coach;

    private String name_coach;

    private Long duration_day;

    private Double course_amount;

    private Double course_percentage;

    private ArrayList<String> course;

    private ArrayList<String> apprentice;

    public ProgramDto(String id_program, String name, LocalDate start_date, LocalDate final_date, String id_coach, String name_coach, Long duration_day, Double course_amount, Double course_percentage, ArrayList<String> course, ArrayList<String> apprentice) {
        ValidateArgument.validateStringNull(this.id_program, Messages.ID_PROGRAMA_NULO);
        this.id_program = id_program;

        ValidateArgument.validateStringNull(this.name, Messages.NOMBRE_PROGRAMA_VACIO);
        this.name = name;

        this.start_date = start_date;
        this.final_date = final_date;

        ValidateArgument.validateStringNull(this.id_coach, Messages.ID_COACH_NULO);
        this.id_coach = id_coach;

        ValidateArgument.validateStringNull(this.name_coach, Messages.NOMBRE_COACH_VACIO);
        this.name_coach = name_coach;

        this.duration_day = duration_day;

        this.course_amount = course_amount;

        this.course_percentage = course_percentage;


        this.course = course;
        this.apprentice = apprentice;
    }
}
