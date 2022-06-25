package org.sofka.app.DukesGN.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("program")
public class Program {
    @Id
    private String id_program;

    private String name;

    private LocalDateTime start_date;

    private LocalDateTime final_date;

    private String id_coach;

    private String name_coach;

    private ArrayList<String> course;

    private ArrayList<String> apprentice;

}