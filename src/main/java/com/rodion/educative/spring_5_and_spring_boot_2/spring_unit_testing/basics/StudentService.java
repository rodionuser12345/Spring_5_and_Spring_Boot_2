package com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing.basics;

public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        super();
        this.studentDao = studentDao;
    }

    public int findTotal() {
        //fetch student marks from a database
        int[] array = studentDao.getMarks();
        int sum = 0;

        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}