package com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class User {
    public String getUserDetails() {
        //interacts with the User repository
        return "user details";
    }
}