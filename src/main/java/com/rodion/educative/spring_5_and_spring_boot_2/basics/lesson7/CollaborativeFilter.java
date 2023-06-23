package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson7;

import org.springframework.stereotype.Component;

@Component
public class CollaborativeFilter implements Filter {

    @Override
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[]{"Finding Nemo", "Ice Age", "Toy Story"};
    }

    @Override
    public String toString() {
        return "CollaborativeFilter{}";
    }
}

