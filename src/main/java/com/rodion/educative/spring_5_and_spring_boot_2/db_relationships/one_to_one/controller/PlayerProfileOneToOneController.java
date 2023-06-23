package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.controller;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.entity.PlayerProfileOneToOne;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.service.PlayerProfileOneToOneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class PlayerProfileOneToOneController {

    private PlayerProfileOneToOneService service;

    public PlayerProfileOneToOneController(PlayerProfileOneToOneService playerProfileOneToOneService) {
        this.service = playerProfileOneToOneService;
    }

    @GetMapping
    public List<PlayerProfileOneToOne> allPlayerProfiles() {
        return service.allPlayerProfiles();
    }

    @GetMapping("/{id}")
    public PlayerProfileOneToOne getPlayerProfile(@PathVariable int id) {
        return service.getPlayerProfile(id);
    }

    @PostMapping
    public PlayerProfileOneToOne addPlayerProfile(@RequestBody PlayerProfileOneToOne playerProfile) {
        return service.addPlayerProfile(playerProfile);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerProfile(@PathVariable int id) {
        service.deletePlayerProfile(id);
    }
}
