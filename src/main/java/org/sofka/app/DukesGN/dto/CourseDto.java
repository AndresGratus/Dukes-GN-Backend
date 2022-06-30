package org.sofka.app.DukesGN.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sofka.app.DukesGN.util.exception.ValidateArgument;
import org.sofka.app.DukesGN.util.message.Messages;

import java.util.ArrayList;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private String id_course;
    private String id_program;
    private String name;
    private Double percentage;
    private ArrayList<String> modules;

    public CourseDto(String id_course, String id_program, String name, Double percentage, ArrayList<String> modules) {
        ValidateArgument.validateStringNull(this.id_course, Messages.ID_CURSO_NULO);
        this.id_course = id_course;

        ValidateArgument.validateStringNull(this.id_program, Messages.ID_PROGRAMA_NULO);
        this.id_program = id_program;

        ValidateArgument.validateStringEmpty(this.name, Messages.NOMBRE_CURSO_VACIO);
        this.name = name;

        this.percentage = percentage;

        this.modules = modules;
    }


}
