package com.yahya.day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Junit5FeaturesTest {

    @DisplayName("Testing addition here")
    @Test
    public void testAdd(){

        assertEquals(10, 5+5);
    }
}
