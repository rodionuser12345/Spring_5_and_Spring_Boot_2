package com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
    @Autowired
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    //use a filter to find recommendations
    public String[] recommendMovies(String movie) {
        String[] results = filter.getRecommendations(movie);
        return results;
    }
}
