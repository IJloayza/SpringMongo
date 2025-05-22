package com.accesdades.mongo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accesdades.mongo.DTO.GameCreateDTO;
import com.accesdades.mongo.DTO.GameResponseDTO;
import com.accesdades.mongo.Service.GameService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/game")
public class RESTController {

  private GameService gameService;

  @Autowired
  public RESTController(GameService gameService) {
      this.gameService = gameService;
  }

  // GET
  @GetMapping("/all")
  public ResponseEntity<Flux<GameResponseDTO>> findAll() {
      return ResponseEntity.ok(gameService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Mono<GameResponseDTO>> findById(@RequestParam String id) {
      return ResponseEntity.ok(gameService.findById(id));
  }

  // POST
  @PostMapping("/save")
  public ResponseEntity<Mono<GameResponseDTO>> save(@RequestBody GameCreateDTO gameDTO) {
      return ResponseEntity.ok(gameService.save(gameDTO));
  }

  // UPDATE
  @PutMapping("/update")
  public ResponseEntity<Mono<GameResponseDTO>> update(@RequestParam String id, @RequestBody GameCreateDTO gameDTO) {
      return ResponseEntity.ok(gameService.update(id, gameDTO));
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Mono<Void>> delete(@RequestParam String id) {
      return ResponseEntity.ok(gameService.delete(id));
  }

}
