package com.rodion.educative.spring_5_and_spring_boot_2.spring_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public List<Player> getAllPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        Optional<Player> player = service.getPlayerById(id);
        return player
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseThrow(() -> new PlayerNotFoundException("Player with id {" + id + "} not found"));
    }

    @PostMapping
    public Player addNewPlayer(@RequestBody Player player) {
        return service.addNewPlayer(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @RequestBody Player playerDetails) {
        Optional<Player> player = service.getPlayerById(id);
        if (player.isPresent()) {
            Player currentPlayer = player.get();
            currentPlayer.setName(playerDetails.getName());
            currentPlayer.setNationality(playerDetails.getNationality());
            currentPlayer.setBirthDate(playerDetails.getBirthDate());
            currentPlayer.setTitles(playerDetails.getTitles());
            return new ResponseEntity<>(service.updatePlayer(currentPlayer), HttpStatus.OK);
        } else {
            throw new PlayerNotFoundException("Player with id {" + id + "} not found");
        }
    }

    @PatchMapping("/players/{id}")
    public Player partialUpdate(@PathVariable int id,
                                @RequestBody Map<String, Object> playerPatch) {
        return service.patch(id, playerPatch);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Player> updatePlayerTitles(@PathVariable int id, @RequestParam int titles) {
        try {
            service.updateTitles(id, titles);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable int id) {
        try {
            service.deletePlayer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
