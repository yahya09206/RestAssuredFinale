package com.yahya.day8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

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

    /** Another way of providing a source for parameterized test is @MethodSource
     * It will allow you to provide the return value the static method with no param
     * as the source for your parameterized test
     */

    @ParameterizedTest
    @MethodSource("get10NumbersList")
    public void testWithMethodSourceDDT(int num) {
        System.out.println("num = " + num);
    }

    @ParameterizedTest
    @MethodSource("com.yahya.day8.MethodSourceUtil#getSomeNames")
    public void testNamesWithMethodSourceDDT(String name){
        System.out.println("name = " + name);
    }

    // Static method that will return List<Integer> that contains 10 numbers
    public static List<Integer> get10NumbersList(){
        // This list could have been the result of very long code here
        List<Integer> myList =  Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return myList;
    }
}
