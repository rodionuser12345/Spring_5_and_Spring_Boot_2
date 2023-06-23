package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.PlayerProfileMTM;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.repository.PlayerProfileMTMRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileMTMService {

    private final PlayerProfileMTMRepository repo;

    public PlayerProfileMTMService(PlayerProfileMTMRepository playerProfileMTMRepository) {
        this.repo = playerProfileMTMRepository;
    }

    public List<PlayerProfileMTM> allPlayerProfiles() {
        return repo.findAll();
    }

    public PlayerProfileMTM getPlayerProfile(int id) {
        return repo.findById(id).get();
    }

    public PlayerProfileMTM addPlayerProfile(PlayerProfileMTM profile) {
        profile.setId(0);
        return repo.save(profile);
    }

    public void deletePlayerProfile(int id) {

        PlayerProfileMTM tempPlayerProfile = repo.findById(id).get();
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
