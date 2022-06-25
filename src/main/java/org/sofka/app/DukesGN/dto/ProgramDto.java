package org.sofka.app.DukesGN.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
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

}
