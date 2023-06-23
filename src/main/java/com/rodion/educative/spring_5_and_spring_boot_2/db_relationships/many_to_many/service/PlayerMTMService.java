package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.PlayerMTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.PlayerProfileMTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Registration;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.repository.PlayerMTMRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerMTMService {

    private final PlayerMTMRepository repo;

    public PlayerMTMService(PlayerMTMRepository playerMTMRepository) {
        this.repo = playerMTMRepository;
    }

    public List<PlayerMTM> allPlayers() {
        return repo.findAll();
    }

    public PlayerMTM getPlayer(int id) {
        return repo.findById(id).get();
    }

    public PlayerMTM addPlayer(PlayerMTM player) {
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

    public PlayerMTM assignProfile(int id, PlayerProfileMTM profile) {
        PlayerMTM player = repo.findById(id).get();
        player.setPlayerProfile(profile);
        //bidirectional
        player.getPlayerProfile().setPlayer(player);
        return repo.save(player);
    }

    public PlayerMTM assignRegistration(int id, Registration registration) {
        PlayerMTM player = repo.findById(id).get();
        player.registerPlayer(registration);
        return repo.save(player);
    }

    public PlayerMTM removeRegistration(int id, Registration registration) {
        PlayerMTM player = repo.findById(id).get();
        player.removeRegistration(registration);
        return repo.save(player);
    }
}
