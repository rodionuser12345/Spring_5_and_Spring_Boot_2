package com.rodion.educative.spring_5_and_spring_boot_2.spirng_data_rest;

import org.springframework.data.repository.ListCrudRepository;

public interface PlayerSpringDataRestRepository extends ListCrudRepository<Player, Integer> {
}
