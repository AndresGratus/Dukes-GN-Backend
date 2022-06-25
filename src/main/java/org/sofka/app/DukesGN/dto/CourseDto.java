package org.sofka.app.DukesGN.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private String id_course;
    private String id_program;
    private String name;
    private ArrayList<String> modules;

}
