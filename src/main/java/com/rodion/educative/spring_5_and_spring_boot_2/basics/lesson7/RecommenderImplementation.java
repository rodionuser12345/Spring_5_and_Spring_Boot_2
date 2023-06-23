package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    private Filter filter;

//    @Autowired
//    public RecommenderImplementation(@Qualifier("collaborativeFilter") Filter filter) {
//        this.filter = filter;
//        System.out.println("Constructor invoked...");
//    }

    @Autowired
    @Qualifier("contentBasedFilter")
    public void setFilter(Filter filter) {
        this.filter = filter;
        System.out.println("Setter method invoked..");
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + filter);
        //return the results
        return filter.getRecommendations(movie);
    }
}