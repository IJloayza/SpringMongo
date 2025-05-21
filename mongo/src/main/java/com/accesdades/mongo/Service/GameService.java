package com.accesdades.mongo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesdades.mongo.DTO.GameCreateDTO;
import com.accesdades.mongo.DTO.GameResponseDTO;
import com.accesdades.mongo.Mapper.GameMapper;
import com.accesdades.mongo.Repository.GameRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GameService {

    private GameRepository gameRepository;
    private GameMapper mapper;

    @Autowired
    public GameService(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.mapper = gameMapper;
    }


    public Mono<GameResponseDTO> save(GameCreateDTO videoGameDTO) {
        return gameRepository.save(mapper.toModel(videoGameDTO))
                .map(mapper::toDTO);
    }

    public Mono<GameResponseDTO> findById(String id) {
        return gameRepository.findById(id).map(mapper::toDTO);
    }

    public Mono<GameResponseDTO> update(String id, GameCreateDTO videoGameDTO) {
        return gameRepository.save(mapper.toModel(videoGameDTO))
                .map(mapper::toDTO);
    }

    public Mono<Void> delete(String id) {
        return gameRepository.deleteById(id);
    }

    public Flux<GameResponseDTO> findAll() {
        return gameRepository.findAll().map(mapper::toDTO);
    }

    public Flux<GameResponseDTO> findByName(String name) {
        return gameRepository.findByName(name).map(mapper::toDTO);
    }

    public Flux<GameResponseDTO> findByGenre(String genre) {
        return gameRepository.findByGenre(genre).map(mapper::toDTO);
    }

    public Flux<String> getDistinctGenres() {
        return gameRepository.getDistinctGenres();
    }

}
