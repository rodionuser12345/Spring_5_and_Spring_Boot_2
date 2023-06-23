package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.one_to_many;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDatabaseOneToManyApplication {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatabaseOneToManyApplication.class, args);
    }
}
