package org.sofka.app.DukesGN.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("course")
public class Course {

    private String id_course;
    private String id_program;
    private String name;
    private ArrayList<String> modules;


}
