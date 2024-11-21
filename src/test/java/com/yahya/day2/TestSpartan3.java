package com.yahya.day2;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class TestSpartan3 {

    @BeforeAll
    public static void setup(){

        baseURI = "http://44.211.192.252:8000";
        basePath = "/api";
    }
}
