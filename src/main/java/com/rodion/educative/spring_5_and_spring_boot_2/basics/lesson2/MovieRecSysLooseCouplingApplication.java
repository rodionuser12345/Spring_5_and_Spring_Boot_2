package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson2;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecSysLooseCouplingApplication {
    public static void main(String[] args) {
        RecommenderImplementation recommender = new RecommenderImplementation(new CollaborativeFilter());
        String[] result = recommender.recommendMovies("Finding Dory");
        System.out.println(Arrays.toString(result));

        System.out.println();

        recommender = new RecommenderImplementation(new ContentBasedFilter());
        result = recommender.recommendMovies("Finding Dory");
        System.out.println(Arrays.toString(result));
    }
}
