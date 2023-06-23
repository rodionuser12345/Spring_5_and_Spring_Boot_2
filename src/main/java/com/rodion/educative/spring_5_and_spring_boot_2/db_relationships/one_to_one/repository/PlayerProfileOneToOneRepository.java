package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.repository;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.entity.PlayerProfileOneToOne;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProfileOneToOneRepository extends ListCrudRepository<PlayerProfileOneToOne, Integer> {
}
