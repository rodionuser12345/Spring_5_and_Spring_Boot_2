package com.rodion.educative.spring_5_and_spring_boot_2.spring_rest;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerSpringDataRepository repo;

    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    public Optional<Player> getPlayerById(int id) {
        return repo.findById(id);
    }

    public Player addNewPlayer(Player player) {
        return repo.save(player);
    }

    public Player updatePlayer(Player player) {
        return repo.save(player);
    }

//    public void updatePlayerTitles(int id, int titles) {
//        Optional<Player> optionalPlayer = repo.findById(id);
//        if (optionalPlayer.isPresent()) {
//            Player player = optionalPlayer.get();
//            player.setTitles(titles);
//            repo.save(player);
//        } else {
//            throw new RuntimeException("Player not found for id :: " + id);
//        }
//    }

    @Transactional
    public void updateTitles(int id, int titles) {
        repo.updateTitles(id, titles);
    }

    public Player patch(int id, Map<String, Object> playerPatch) {

        Optional<Player> player = repo.findById(id);

        player.ifPresentOrElse(player1 -> playerPatch.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Player.class, key);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, player1, value);
        }), () -> {
            throw new PlayerNotFoundException("Player with id {" + id + "} not found");
        });
        return repo.save(player.get());
    }

    public void deletePlayer(int id) {
        repo.deleteById(id);
    }
}


