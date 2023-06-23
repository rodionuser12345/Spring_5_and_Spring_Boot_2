package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDatabaseManyToManyApplication {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatabaseManyToManyApplication.class, args);
    }
}
