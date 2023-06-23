package com.rodion.educative.spring_5_and_spring_boot_2.spring_boot_jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
    private int id;
    private String name;
    private String nationality;
    private Date birthDate;
    private int titles;
}