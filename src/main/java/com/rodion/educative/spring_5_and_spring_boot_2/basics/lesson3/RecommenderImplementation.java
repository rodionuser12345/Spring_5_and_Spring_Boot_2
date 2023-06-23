package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson3;

import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    private final Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + filter);
        //return the results
        return filter.getRecommendations(movie);
    }
}