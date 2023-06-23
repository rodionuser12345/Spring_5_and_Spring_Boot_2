package com.rodion.educative.spring_5_and_spring_boot_2.spring_data_jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {

    @Autowired
    PlayerRepository repo;

    @Autowired
    PlayerSpringRepository springDataRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
//                new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
//
//        logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
//                new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));
//
//        logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
//                new Player("Thiem", "Austria",
//                        new Date(System.currentTimeMillis()), 17)));
//
//        logger.info("All Players Data: {}", repo.getAllPlayers());
//
//        //update player
//        logger.info("\n\n>> Updating Player with Id 3: {}\n", repo.updatePlayer(
//                new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));
//        //get player
//        logger.info("\n\n>> Player with id 3: {}\n", repo.getPlayerById(3));
//
//        //delete player
//        repo.deleteById(2);
//
//        logger.info("All Players Data: {}", repo.getAllPlayers());

        //Inserting rows
        logger.info("Inserting Player: {}", springDataRepo.save(new Player("Djokovic", "Serbia",
                Date.valueOf("1987-05-22"), 81)));
        logger.info("Inserting Player: {}", springDataRepo.save(new Player("Monfils", "France",
                Date.valueOf("1986-09-01"), 10)));
        logger.info("Inserting Player: {}", springDataRepo.save(new Player("Thiem", "Austria",
                new Date(System.currentTimeMillis()), 17)));

        //Get all rows
        logger.info("All Players Data: {}", springDataRepo.findAll());

        //Updating row
        logger.info("Updating Player with Id 3: {}", springDataRepo.save(new Player(3, "Thiem", "Austria",
                Date.valueOf("1993-09-03"), 17)));

        //Get row by id
        logger.info("Player with id 3: {}", springDataRepo.findById(3));

        //Delete row by id
        springDataRepo.deleteById(2);

        //Get all rows
        logger.info("All Players Data: {}", springDataRepo.findAll());

        //Find player by nationality
        //select p from Player p where p.nationality = ?1
        logger.info("Players from Austria: {}", springDataRepo.findByNationality("Austria"));
    }
}
