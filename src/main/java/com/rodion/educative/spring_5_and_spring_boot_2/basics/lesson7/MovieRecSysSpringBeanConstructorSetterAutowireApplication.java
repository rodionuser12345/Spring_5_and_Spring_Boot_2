package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecSysSpringBeanConstructorSetterAutowireApplication {
    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(
                MovieRecSysSpringBeanConstructorSetterAutowireApplication.class, args);

        //RecommenderImplementation injects dependency using constructor
        System.out.println("Calling getBean() on RecommenderImplementation");
        RecommenderImplementation recommender = appContext.getBean(
                RecommenderImplementation.class);

        String[] result = recommender.recommendMovies("Finding Dory");
        System.out.println(Arrays.toString(result));
    }
}
