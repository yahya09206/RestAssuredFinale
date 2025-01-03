package com.yahya.day8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MathTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/Math.csv", numLinesToSkip = 1)
    public void testMath(int a, int b, int expected) {

    }
}
