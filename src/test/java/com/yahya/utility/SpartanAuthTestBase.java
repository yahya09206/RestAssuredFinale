package com.yahya.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class SpartanAuthTestBase {

    @BeforeAll
    public static void setup(){

        baseURI = "http://54.236.150.168:7000";
        //baseURI = "http://44.211.192.252:7000";
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
}
