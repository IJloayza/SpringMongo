package com.accesdades.mongo.Repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import com.accesdades.mongo.Model.Game;

import reactor.core.publisher.Flux;

@Repository
@EnableReactiveMongoRepositories
public interface GameRepository extends ReactiveMongoRepository<Game, String> {

    // Buscamos por el nombre del videojuego
    @Query("{ 'Game' : { $regex: '^?0', $options: 'i' } }")
    Flux<Game> findByName(String name);
    // Buscamos por el genero del videojuego
    @Query("{ 'Genre' : { $regex: '^?0', $options: 'i' } }")
    Flux<Game> findByGenre(String genre);
    
    // Los diferentes generos de videojuegos (usando un aggregate)
    @Query(value = "[{ $group: { _id: '$Genre' } }]", delete = false)
    Flux<String> getDistinctGenres();

}
