package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.repository;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Tournament;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends ListCrudRepository<Tournament, Integer> {
}
