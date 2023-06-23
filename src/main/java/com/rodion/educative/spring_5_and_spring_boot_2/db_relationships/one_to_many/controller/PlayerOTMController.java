package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.controller;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.entity.PlayerOTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.entity.PlayerProfileOTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.entity.Registration;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.service.PlayerOMTService;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.service.PlayerProfileOTMService;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerOTMController {

    private final PlayerOMTService service;
    private final PlayerProfileOTMService profileService;
    private final RegistrationService registrationService;

    public PlayerOTMController(PlayerOMTService playerOMTService,
                               PlayerProfileOTMService playerProfileOnTMService, RegistrationService registrationService) {
        this.service = playerOMTService;
        this.profileService = playerProfileOnTMService;
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<PlayerOTM> allPlayers() {
        return service.allPlayers();
    }

    @GetMapping("/{id}")
    public PlayerOTM getPlayer(@PathVariable int id) {
        return service.getPlayer(id);
    }

    @PostMapping
    public PlayerOTM addPlayer(@RequestBody PlayerOTM player) {
        return service.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deletePlayer(id);
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public PlayerOTM assignDetail(@PathVariable int id, @PathVariable int profile_id) {
        PlayerProfileOTM profile = profileService.getPlayerProfile(profile_id);
        System.out.println(profile);
        return service.assignProfile(id, profile);
    }

    @PutMapping("/{id}/registrations/{registration_id}")
    public PlayerOTM assignRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return service.assignRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public PlayerOTM removeRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return service.removeRegistration(id, registration);
    }
}
