package com.rodion.educative.spring_5_and_spring_boot_2.basics.lesson4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
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
