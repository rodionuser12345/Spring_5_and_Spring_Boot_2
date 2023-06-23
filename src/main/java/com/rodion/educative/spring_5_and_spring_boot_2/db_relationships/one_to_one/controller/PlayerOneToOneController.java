package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.controller;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.entity.PlayerOneToOne;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.entity.PlayerProfileOneToOne;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.service.PlayerOneToOneService;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.service.PlayerProfileOneToOneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerOneToOneController {

    private PlayerOneToOneService service;
    private PlayerProfileOneToOneService profileService;

    public PlayerOneToOneController(PlayerOneToOneService playerOneToOneService,
                                    PlayerProfileOneToOneService playerProfileOneToOneService) {
        this.service = playerOneToOneService;
        this.profileService = playerProfileOneToOneService;
    }

    @GetMapping
    public List<PlayerOneToOne> allPlayers() {
        return service.allPlayers();
    }

    @GetMapping("/{id}")
    public PlayerOneToOne getPlayer(@PathVariable int id) {
        return service.getPlayer(id);
    }

    @PostMapping
    public PlayerOneToOne addPlayer(@RequestBody PlayerOneToOne player) {
        return service.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deletePlayer(id);
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public PlayerOneToOne assignDetail(@PathVariable int id, @PathVariable int profile_id) {
        PlayerProfileOneToOne profile = profileService.getPlayerProfile(profile_id);
        System.out.println(profile);
        return service.assignProfile(id, profile);
    }

}
