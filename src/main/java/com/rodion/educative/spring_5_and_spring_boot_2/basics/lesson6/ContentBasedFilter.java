package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson6;

import org.springframework.stereotype.Component;

@Component("CBF")
//@Component
//@Qualifier("CBF")
public class ContentBasedFilter implements Filter {

    @Override
    public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }

    @Override
    public String toString() {
        return "ContentBasedFilter{}";
    }
}