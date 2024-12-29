package com.yahya.day7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class ZipcodeAPITest {


    @BeforeAll
    public static void setup(){

        baseURI = "https://api.zippopotam.us";
        basePath = "/us";
    }

    @AfterAll
    public static void tearDown(){

        reset();
    }


}
