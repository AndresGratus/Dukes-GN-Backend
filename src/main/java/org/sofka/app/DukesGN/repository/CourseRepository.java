package org.sofka.app.DukesGN.repository;

import org.sofka.app.DukesGN.collection.Course;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String> {

}