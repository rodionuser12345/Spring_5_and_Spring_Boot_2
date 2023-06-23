package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson6;

import org.springframework.stereotype.Component;

@Component("CF")
public class CollaborativeFilter implements Filter {

    @Override
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[]{};
    }

    @Override
    public String toString() {
        return "CollaborativeFilter{}";
    }
}
