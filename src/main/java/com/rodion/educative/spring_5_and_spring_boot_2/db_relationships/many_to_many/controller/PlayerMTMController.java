package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.controller;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.PlayerMTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.PlayerProfileMTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Registration;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service.PlayerMTMService;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service.PlayerProfileMTMService;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerMTMController {

    private final PlayerMTMService service;
    private final PlayerProfileMTMService profileService;
    private final RegistrationService registrationService;

    public PlayerMTMController(PlayerMTMService playerMTMService,
                               PlayerProfileMTMService playerProfileMTMService, RegistrationService registrationService) {
        this.service = playerMTMService;
        this.profileService = playerProfileMTMService;
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<PlayerMTM> allPlayers() {
        return service.allPlayers();
    }

    @GetMapping("/{id}")
    public PlayerMTM getPlayer(@PathVariable int id) {
        return service.getPlayer(id);
    }

    @PostMapping
    public PlayerMTM addPlayer(@RequestBody PlayerMTM player) {
        return service.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deletePlayer(id);
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public PlayerMTM assignDetail(@PathVariable int id, @PathVariable int profile_id) {
        PlayerProfileMTM profile = profileService.getPlayerProfile(profile_id);
        System.out.println(profile);
        return service.assignProfile(id, profile);
    }

    @PutMapping("/{id}/registrations/{registration_id}")
    public PlayerMTM assignRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return service.assignRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public PlayerMTM removeRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return service.removeRegistration(id, registration);
    }
}
