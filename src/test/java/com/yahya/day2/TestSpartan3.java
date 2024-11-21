package com.yahya.day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class TestSpartan3 {

    @BeforeAll
    public static void setup(){

        baseURI = "http://44.211.192.252:8000";
        basePath = "/api";
    }

    @AfterAll
    public static void tearDown(){

        /**
         * In order to avoid the static value being accidentally carried over
         * to a different class when we do a different api
         * it's better if we set baseURI basePath back to its original value using reset method
         * RestAssured.reset();
         */
        reset();
    }

    @Test
    public void testAllSpartans(){

        Response response = get("/spartans");
        response.prettyPrint();
    }
}
