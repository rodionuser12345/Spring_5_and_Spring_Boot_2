package com.rodion.educative.spring_5_and_spring_boot_2.spring_rest;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayerSpringDataRepository extends ListCrudRepository<Player, Integer> {

    @Modifying
    @Query("update Player p set p.titles = :titles where p.id = :id")
    void updateTitles(@Param("id") int id, @Param("titles") int titles);
}
