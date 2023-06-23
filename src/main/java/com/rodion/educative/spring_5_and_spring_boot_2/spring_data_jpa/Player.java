package com.rodion.educative.spring_5_and_spring_boot_2.spring_data_jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "Player")
@NamedQuery(name = "get_all_players", query = "select p from Player p")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Column(name = "nationality")
    private String nationality;
    private Date birthDate;
    private int titles;

    public Player(String name, String nationality, Date birthDate, int titles) {
        super();
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }
}