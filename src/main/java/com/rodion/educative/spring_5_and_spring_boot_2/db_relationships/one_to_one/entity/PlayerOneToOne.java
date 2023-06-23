package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_profile_id", referencedColumnName = "id")
    @JsonManagedReference
    private PlayerProfileOneToOne playerProfileOneToOne;
}
