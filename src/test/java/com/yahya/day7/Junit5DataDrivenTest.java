package com.yahya.day7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Junit5DataDrivenTest {

    // Given these Strings of data
    // "Furkan", "Abbos", "Shazia", "Mohamed"
    // write a data driven test to check if the length of these strings are greater than 5
    @ParameterizedTest
    @ValueSource(strings = {"Furkan", "Abbos", "Shazia", "Mohamed"})
    public void testNameLength(String names){
        System.out.println("names = " + names);
        assertTrue(names.length() > 3);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/People.csv", numLinesToSkip = 1)
    public void testPerson(String nameParam, String genderParam, long phoneParam){

        System.out.println("nameParam = " + nameParam);
        System.out.println("genderParam = " + genderParam);
        System.out.println("phoneParam = " + phoneParam);

    }
}
