package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.service;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.entity.PlayerProfileOTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many.repository.PlayerProfileOTMRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileOTMService {

    private final PlayerProfileOTMRepository repo;

    public PlayerProfileOTMService(PlayerProfileOTMRepository playerProfileOneToOneRepository) {
        this.repo = playerProfileOneToOneRepository;
    }

    public List<PlayerProfileOTM> allPlayerProfiles() {
        return repo.findAll();
    }

    public PlayerProfileOTM getPlayerProfile(int id) {
        return repo.findById(id).get();
    }

    public PlayerProfileOTM addPlayerProfile(PlayerProfileOTM profile) {
        profile.setId(0);
        return repo.save(profile);
    }

    public void deletePlayerProfile(int id) {

        PlayerProfileOTM tempPlayerProfile = repo.findById(id).get();
        //set the playerProfile field of the Player object to null
        tempPlayerProfile.getPlayer().setPlayerProfile(null);
        //set the player field of the PlayerProfile object to null
        tempPlayerProfile.setPlayer(null);
        //save changes
        repo.save(tempPlayerProfile);
        //delete the PlayerProfile object
        repo.delete(tempPlayerProfile);
    }
}
