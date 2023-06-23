package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.service;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.entity.PlayerOTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.entity.PlayerProfileOTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.entity.Registration;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.repository.PlayerOTMRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerOMTService {

    private final PlayerOTMRepository repo;

    public PlayerOMTService(PlayerOTMRepository playerOneToOneRepository) {
        this.repo = playerOneToOneRepository;
    }

    public List<PlayerOTM> allPlayers() {
        return repo.findAll();
    }

    public PlayerOTM getPlayer(int id) {
        return repo.findById(id).get();
    }

    public PlayerOTM addPlayer(PlayerOTM player) {
        player.setId(0);
        //check if player contains nested profile
        if (player.getPlayerProfile() != null) {
            player.getPlayerProfile().setPlayer(player);
        }
        return repo.save(player);
    }

    public void deletePlayer(int id) {
        repo.deleteById(id);
    }

    public PlayerOTM assignProfile(int id, PlayerProfileOTM profile) {
        PlayerOTM player = repo.findById(id).get();
        player.setPlayerProfile(profile);
        //bidirectional
        player.getPlayerProfile().setPlayer(player);
        return repo.save(player);
    }

    public PlayerOTM assignRegistration(int id, Registration registration) {
        PlayerOTM player = repo.findById(id).get();
        player.registerPlayer(registration);
        return repo.save(player);
    }

    public PlayerOTM removeRegistration(int id, Registration registration) {
        PlayerOTM player = repo.findById(id).get();
        player.removeRegistration(registration);
        return repo.save(player);
    }
}
