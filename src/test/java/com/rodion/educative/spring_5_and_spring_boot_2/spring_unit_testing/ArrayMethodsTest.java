package com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing;

import com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing.basics.ArrayMethods;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayMethodsTest {

    ArrayMethods arrayMethods;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Run this code before all tests");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Run this code after all tests");
    }

    @BeforeEach
    void init() {
        //Initialize the object here
        System.out.println("Initializing before test");
        arrayMethods = new ArrayMethods();
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("Clean up after test");
    }

    @Test
    void test_findIndex() {
        int result = arrayMethods.findIndex(new int[]{1, 2, 3}, 2);

        assertEquals(1, result);
    }

    @Test
    void searchForNumber() {
    }
}