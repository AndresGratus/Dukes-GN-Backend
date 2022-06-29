package org.sofka.app.DukesGN.repository;

import org.sofka.app.DukesGN.collection.Program;
import org.sofka.app.DukesGN.dto.ProgramDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface ProgramRepository extends ReactiveMongoRepository<Program, String> {
    Flux<List<ProgramDto>> saveAll(List<ProgramDto> listProgram);
}
