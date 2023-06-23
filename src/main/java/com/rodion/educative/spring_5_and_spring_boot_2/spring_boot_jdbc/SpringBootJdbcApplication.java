package com.rodion.educative.spring_5_and_spring_boot_2.spring_boot_jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerDao dao;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All Players Data: {}", dao.getAllPlayers());

        logger.info("Player with Id 3: {}", dao.getPlayerById(3));

        //Inserting a player
        logger.info("Inserting Player 4: {}", dao.insertPlayer(
                new Player(4, "Thiem", "Austria",
                        new Date(System.currentTimeMillis()),
                        17)));
        logger.info("All Players Data: {}", dao.getAllPlayers());

        //Updating a player
        logger.info("Updating Player with Id 4: {}", dao.updatePlayer(
                new Player(4, "Thiem", "France",
                        Date.valueOf("1993-09-03"), 17)));

        //View player by ID
        logger.info("Players with Id 4: {}", dao.getPlayerById(4));

        logger.info("Deleting Player with Id 2: {}", dao.deletePlayerById(2));
        logger.info("All Players Data: {}", dao.getAllPlayers());

        dao.createTournamentTable();

        logger.info("French Players: {}", dao.getPlayerByNationality("France"));
    }
}
