package com.accesdades.mongo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accesdades.mongo.DTO.GameResponseDTO;
import com.accesdades.mongo.Service.GameService;

import reactor.core.publisher.Flux;

@RestController
public class RESTController {

  private GameService gameService;

  @Autowired
  public RESTController(GameService gameService) {
      this.gameService = gameService;
  }

  @GetMapping("/games")
  public ResponseEntity<Flux<GameResponseDTO>> findAll() {
      return ResponseEntity.ok(gameService.findAll());
  }

}
