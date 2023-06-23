package com.rodion.educative.spring_5_and_spring_boot_2.spring_aop;

import com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.business.SimilarityFiltering;
import com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.business.WatchHistoryFiltering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderAopApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SimilarityFiltering filter1;

    @Autowired
    private WatchHistoryFiltering filter2;

    public static void main(String[] args) {
        SpringApplication.run(MovieRecommenderAopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("{}", filter1.contentBasedFiltering());
        logger.info("{}", filter2.collaborativeFiltering());
    }
}
