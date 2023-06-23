package com.rodion.educative.spring_5_and_spring_boot_2.sprint_boot_basics;


public class Movie {
    int id;
    String name;
    double rating;

    public Movie() {
    }

    public Movie(int id, String name, double rating) {
        super();
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", name=" + name + ", rating=" + rating + "]";
    }
}
