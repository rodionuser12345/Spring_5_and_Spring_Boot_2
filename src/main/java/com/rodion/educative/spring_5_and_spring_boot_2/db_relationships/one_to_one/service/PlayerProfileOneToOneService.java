package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.service;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.entity.PlayerProfileOneToOne;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.repository.PlayerProfileOneToOneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileOneToOneService {

    private final PlayerProfileOneToOneRepository repo;

    public PlayerProfileOneToOneService(PlayerProfileOneToOneRepository playerProfileOneToOneRepository) {
        this.repo = playerProfileOneToOneRepository;
    }

    public List<PlayerProfileOneToOne> allPlayerProfiles() {
        return repo.findAll();
    }

    public PlayerProfileOneToOne getPlayerProfile(int id) {
        return repo.findById(id).get();
    }

    public PlayerProfileOneToOne addPlayerProfile(PlayerProfileOneToOne profile) {
        profile.setId(0);
        return repo.save(profile);
    }

    public void deletePlayerProfile(int id) {

        PlayerProfileOneToOne tempPlayerProfile = repo.findById(id).get();
        //set the playerProfile field of the Player object to null
        tempPlayerProfile.getPlayerOneToOne().setPlayerProfileOneToOne(null);
        //set the player field of the PlayerProfile object to null
        tempPlayerProfile.setPlayerOneToOne(null);
        //save changes
        repo.save(tempPlayerProfile);
        //delete the PlayerProfile object
        repo.delete(tempPlayerProfile);
    }
}
