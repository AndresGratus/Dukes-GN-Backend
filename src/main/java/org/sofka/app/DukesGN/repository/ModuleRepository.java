package org.sofka.app.DukesGN.repository;

import org.sofka.app.DukesGN.collection.Module;
import org.sofka.app.DukesGN.dto.ModuleDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface ModuleRepository extends ReactiveMongoRepository<Module, String> {
    Flux<List<ModuleDto>> saveAll(List<ModuleDto> moduleDtoList);
}
