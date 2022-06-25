package org.sofka.app.DukesGN.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDto {
    private String id_module;
    private String id_course;
    private String name;
    private Double score;
    private Double percentage;
}
