package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_one.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerProfileOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String twitter;

    @OneToOne(mappedBy = "playerProfileOneToOne")
    @JsonBackReference
    private PlayerOneToOne playerOneToOne;
}
