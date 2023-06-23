package com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.business;

import com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchHistoryFiltering {

    @Autowired
    private User user;

    public String collaborativeFiltering() {
        String userDetails = user.getUserDetails();
        return userDetails;
    }
}
