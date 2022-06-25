package org.sofka.app.DukesGN.collection;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("module")
public class Module {
    @Id
    private String id_module;
    private String id_course;
    private String name;
    private Double score;
    private Double percentage;
}
