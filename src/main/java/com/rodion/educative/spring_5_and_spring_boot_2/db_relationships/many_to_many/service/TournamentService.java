package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Category;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Registration;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Tournament;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    private final TournamentRepository repo;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.repo = tournamentRepository;
    }

    public List<Tournament> allTournaments() {
        return repo.findAll();
    }

    public Tournament getTournament(int id) {
        return repo.findById(id).get();
    }

    public Tournament addTournament(Tournament tournament) {
        tournament.setId(0);
        return repo.save(tournament);
    }
    
    public Tournament addCategory(int id, Category category) {
        Tournament tournament = repo.findById(id).get();
        tournament.addCategory(category);
        return repo.save(tournament);
    }

    public void deleteTournament(int id) {
        repo.deleteById(id);
    }

    public Tournament addRegistration(int id, Registration registration) {
        Tournament tournament = repo.findById(id).get();
        tournament.addRegistration(registration);
        return repo.save(tournament);
    }

    public Tournament removeRegistration(int id, Registration registration) {
        Tournament tournament = repo.findById(id).get();
        tournament.removeRegistration(registration);
        return repo.save(tournament);
    }

}
