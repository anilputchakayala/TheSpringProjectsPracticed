package com.anil.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");
    int[] numbers = {1,2,3};

    @Test
    void test(){
        assertEquals(3, todos.size());
        assertTrue(todos.contains("AWS"));
        assertFalse(todos.contains("GCP"));
        assertArrayEquals(new int[]{1,2,3}, numbers);
    }

}