package com.anil.junit;

public class MyMath {

    public int calculateMax(int[] numbers){
        int sum = 0;
        for(int number:numbers){
            sum += number;
        }
        return sum;
    }
}
