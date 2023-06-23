package com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.business;

import com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect.MeasureTime;
import com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.data.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimilarityFiltering {

    @Autowired
    private Movie movie;

    @MeasureTime
    public String contentBasedFiltering() {
        return movie.getMovieDetails();
    }
}
