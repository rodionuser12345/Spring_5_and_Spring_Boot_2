package com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing;

import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements Filter {

    public String[] getRecommendations(String movie) {
        //implement logic of content based filter
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
