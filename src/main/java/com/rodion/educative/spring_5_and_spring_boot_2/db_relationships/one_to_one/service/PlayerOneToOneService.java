package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.service;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.entity.PlayerOneToOne;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.entity.PlayerProfileOneToOne;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.repository.PlayerOneToOneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerOneToOneService {

    private final PlayerOneToOneRepository repo;

    public PlayerOneToOneService(PlayerOneToOneRepository playerOneToOneRepository) {
        this.repo = playerOneToOneRepository;
    }

    public List<PlayerOneToOne> allPlayers() {
        return repo.findAll();
    }

    public PlayerOneToOne getPlayer(int id) {
        return repo.findById(id).get();
    }

    public PlayerOneToOne addPlayer(PlayerOneToOne player) {
        player.setId(0);
        return repo.save(player);
    }

    public void deletePlayer(int id) {
        repo.deleteById(id);
    }

    public PlayerOneToOne assignProfile(int id, PlayerProfileOneToOne profile) {
        PlayerOneToOne player = repo.findById(id).get();
        player.setPlayerProfileOneToOne(profile);
        return repo.save(player);
    }
}
