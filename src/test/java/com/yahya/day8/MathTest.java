package com.yahya.day8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MathTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/Math.csv", numLinesToSkip = 1)
    public void testMath(int a, int b, int expected) {

        System.out.println(a + " + " + b + " should be " + expected);
        // assert using hamcrest matcher
        assertThat(a + b, equalTo(expected));
    }
}
