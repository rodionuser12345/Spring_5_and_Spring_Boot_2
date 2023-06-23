package com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.data;

import com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect.MeasureTime;
import org.springframework.stereotype.Repository;

@Repository
public class Movie {
    @MeasureTime
    public String getMovieDetails() {
        //interacts with the Movie repository
        return "movie details";
    }
}