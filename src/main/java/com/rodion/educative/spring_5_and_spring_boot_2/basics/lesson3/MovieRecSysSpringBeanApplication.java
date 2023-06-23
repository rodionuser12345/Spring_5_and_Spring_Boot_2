package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecSysSpringBeanApplication {
    public static void main(String[] args) {
        //ApplicationContext manages the beans and dependencies
        ApplicationContext appContext = SpringApplication.run(
                MovieRecSysSpringBeanApplication.class, args);

        //use ApplicationContext to find which filter is being used
        RecommenderImplementation recommender = appContext.getBean(
                RecommenderImplementation.class);

        //call method to get recommendations
        String[] result = recommender.recommendMovies("Finding Dory");

        //display results
        System.out.println(Arrays.toString(result));
    }
}
