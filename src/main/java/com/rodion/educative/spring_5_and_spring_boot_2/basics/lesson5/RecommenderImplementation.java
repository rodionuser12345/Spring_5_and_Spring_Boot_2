package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    @Autowired
    private Filter contentBasedFilter;

    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + contentBasedFilter);
        //return the results
        return contentBasedFilter.getRecommendations(movie);
    }
}