package org.sofka.app.DukesGN.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends ReactiveMongoRepository<Module, String> {

}
