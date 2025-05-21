package com.accesdades.mongo.Service;

import com.accesdades.mongo.DTO.GameCreateDTO;
import com.accesdades.mongo.DTO.GameResponseDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IGameService {

  public Mono<GameResponseDTO> save(GameCreateDTO videoGameDTO);
  public Mono<GameResponseDTO> findById(String id);
  public Mono<GameResponseDTO> update(String id, GameCreateDTO videoGameDTO);
  public Mono<Void> delete(String id);

  // Fluxos
  public Flux<GameResponseDTO> findAll();
  public Flux<GameResponseDTO> findByName(String name);
  public Flux<GameResponseDTO> findByGenre(String genre);
  public Flux<String> getDistinctGenres();


}
