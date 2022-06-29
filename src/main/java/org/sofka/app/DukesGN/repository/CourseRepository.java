package org.sofka.app.DukesGN.repository;

import org.sofka.app.DukesGN.collection.Course;
import org.sofka.app.DukesGN.dto.CourseDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;


@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String> {

    Flux<List<CourseDto>> saveAll(List<CourseDto> courseDtoList);
}
