package com.yahya.tests.day11;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class XMLResponseTest {

    @BeforeAll
    public static void setUp(){
        baseURI = "http://ergast.com" ;
        basePath= "/api/f1";
    }


    @AfterAll
    public static void tearDown(){
        reset();
    }
}
