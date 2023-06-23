package com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CollaborativeFilter implements Filter {

    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[]{"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
