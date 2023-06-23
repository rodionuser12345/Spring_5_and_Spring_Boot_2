package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tournament_id", referencedColumnName = "id")
    private List<Registration> registrations = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "tournament_category",
            joinColumns = @JoinColumn(name = "tournament_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("tournaments")
    private List<Category> playingCategories = new ArrayList<>();

    public void addRegistration(Registration reg) {
        registrations.add(reg);
    }

    public void removeRegistration(Registration reg) {
        if (registrations != null)
            registrations.remove(reg);
    }

    public void addCategory(Category category) {
        playingCategories.add(category);
        //set up bidirectional relationship
        category.getTournaments().add(this);
    }

    public void removeCategory(Category category) {
        if (playingCategories != null)
            playingCategories.remove(category);
        //update bidirectional relationship
        category.getTournaments().remove(this);
    }

}
