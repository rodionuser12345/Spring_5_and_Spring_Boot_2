package com.rodion.educative.spring_5_and_spring_boot_2.spring_data_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PlayerRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Player> getAllPlayers() {
        TypedQuery<Player> getAll = entityManager.createNamedQuery(
                "get_all_players", Player.class);
        return getAll.getResultList();
    }

    public Player getPlayerById(int id) {
        return entityManager.find(Player.class, id);
    }

    public Player insertPlayer(Player player) {
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player) {
        return entityManager.merge(player);
    }

    public void deleteById(int id) {
        Player player = entityManager.find(Player.class, id);
        entityManager.remove(player);
    }
}
