package com.rodion.educative.spring_5_and_spring_boot_2.spring_data_jpa;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PlayerSpringRepository extends ListCrudRepository<Player, Integer> {
    List<Player> findByNationality(String nationality);
}
