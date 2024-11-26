package com.yahya.day6;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class MovieAPI_Test {

    @BeforeAll
    public static void setup(){
        baseURI = "http://www.omdbapi.com";
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }
}
