package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.controller;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Category;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Registration;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Tournament;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service.CategoryService;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service.RegistrationService;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service.TournamentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService service;
    private final RegistrationService registrationService;
    private final CategoryService categoryService;

    public TournamentController(TournamentService tournamentService, RegistrationService registrationService,
                                CategoryService categoryService) {
        this.service = tournamentService;
        this.registrationService = registrationService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Tournament> allTournaments() {
        return service.allTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable int id) {
        return service.getTournament(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return service.addTournament(tournament);
    }

    @PutMapping("/{id}/registrations/{registration_id}")
    public Tournament addRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return service.addRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public Tournament removeRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return service.removeRegistration(id, registration);
    }

    @PutMapping("/{id}/categories/{category_id}")
    public Tournament addCategory(@PathVariable int id, @PathVariable int category_id) {
        Category category = categoryService.getCategory(category_id);
        return service.addCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable int id) {
        service.deleteTournament(id);
    }
}
