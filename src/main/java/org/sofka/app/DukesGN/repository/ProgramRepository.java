package org.sofka.app.DukesGN.repository;

import org.sofka.app.DukesGN.collection.Program;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends ReactiveMongoRepository<Program, String> {
}
