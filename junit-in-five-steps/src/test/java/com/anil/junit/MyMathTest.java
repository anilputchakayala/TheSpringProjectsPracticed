package com.anil.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    private MyMath myMath = new MyMath();

    @Test
    void calculateMax_FiveMemberArray(){
        assertEquals(15, myMath.calculateMax(new int[]{1,2,3,4,5}));
    }

    @Test
    void calculateMax_ZeroLengthArray(){
        assertEquals(0, myMath.calculateMax(new int[]{}));
    }
}