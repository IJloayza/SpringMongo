package com.accesdades.mongo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.accesdades.mongo.DTO.GameCreateDTO;
import com.accesdades.mongo.DTO.GameResponseDTO;
import com.accesdades.mongo.Service.GameService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/game")
public class RESTController {

    private final GameService gameService;

    @Autowired
    public RESTController(GameService gameService) {
        this.gameService = gameService;
    }

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<Flux<GameResponseDTO>> findAll() {
        return ResponseEntity.ok(gameService.findAll());
    }

  @GetMapping("/{id}")
  public ResponseEntity<Mono<GameResponseDTO>> findById(@PathVariable String id) {
      return ResponseEntity.ok(gameService.findById(id)
          .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found")))););
  }

  @GetMapping("/byName")
  public ResponseEntity<Flux<GameResponseDTO>> findByName(@RequestParam String name) {
      return ResponseEntity.ok(gameService.findByName(name));
  }

    // POST
    @PostMapping("/save")
    public ResponseEntity<Mono<GameResponseDTO>> save(@RequestBody GameCreateDTO gameDTO) {
        Mono<GameResponseDTO> savedGame = gameService.save(gameDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Mono<GameResponseDTO>> update(@PathVariable String id, @RequestBody GameCreateDTO gameDTO) {
        Mono<GameResponseDTO> updated = gameService.update(id, gameDTO)
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found")));
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}
