package org.sofka.app.DukesGN.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sofka.app.DukesGN.util.exception.ValidateArgument;
import org.sofka.app.DukesGN.util.message.Messages;


@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class ModuleDto {

    private String id_module;
    private String id_course;
    private String name;
    private Double score;
    private Double percentage;
    private Long duration;


    public ModuleDto(String id_module, String id_course, String name, Double score, Double percentage, Long duration) {
        ValidateArgument.validateStringNull(this.id_module, Messages.ID_MODULO_NULO);
        this.id_module = id_module;

        ValidateArgument.validateStringNull(this.id_course, Messages.ID_CURSO_NULO);
        this.id_course = id_course;

        ValidateArgument.validateStringEmpty(this.name, Messages.NOMBRE_MODULO_VACIO);
        this.name = name;

        ValidateArgument.valiteNumberNegative(this.score, Messages.VALOR_NOTA_MINIMO);
        ValidateArgument.validateNumberMax(this.score, Messages.VALOR_NOTA_MAXIMO);
        this.score = score;

        ValidateArgument.valiteNumberNegative(this.percentage, Messages.VALOR_PORCENTAJE_MINIMO);
        ValidateArgument.validateNumberMax(this.percentage, Messages.VALOR_PORCENTAJE_MAXIMO);
        this.percentage = percentage;

        this.duration = duration;
    }
}
