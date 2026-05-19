package com.anil.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("before all");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
    }

    @Test
    void test1(){
        System.out.println("test1");
    }

    @Test
    void test2(){
        System.out.println("test2");
    }

    @Test
    void test3(){
        System.out.println("test3");
    }

    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

}