package com.yahya.utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.reset;

public class LibraryAPI_BaseTest {

    @BeforeAll
    public static void setup(){

        RestAssured.baseURI = "https://library2.cydeo.com";
        RestAssured.basePath = "rest/v1";
    }

    @AfterAll
    public static void teardown(){
        reset();
    }
}
