package com.accesdades.mongo.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import com.accesdades.mongo.DTO.VideoGameDTO;
import com.accesdades.mongo.Model.VideoGame;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@EnableReactiveMongoRepositories
public interface VideoGameRepository extends ReactiveMongoRepository<VideoGame, String> {
    // Desa un nou usuari
    Mono<VideoGame> save(VideoGame videoGame);

    // Cerca un usuari pel seu ID
    Mono<VideoGame> findById(String id);

    // Recupera tots els usuaris
    Flux<VideoGame> findAll();

    // Actualitza un usuari a partir d’un DTO
    Mono<VideoGame> update(VideoGameDTO videoGameDTO);

    // Esborra un usuari pel seu ID
    Mono<Void> delete(String id);
}
