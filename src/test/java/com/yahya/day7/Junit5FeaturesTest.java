package com.yahya.day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Junit5FeaturesTest {

    @DisplayName("Testing addition here")
    @Test
    public void testAdd(){

        assertEquals(10, 5+5, "Hey it was not 10");
    }

    @Test
    public void testMoreThan10(){
        // assuming these numbers are from a coding problem 11, 44, 33, 5, 6, 88
        // assert that all of these numbers are above 10
        int num = 11;
        assertTrue(num > 10, "Number is not greater than 10");

    }
}
