package com.yahya.day8;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class ZipcodeMethodSourceTest {

    /**
     * Method that will return all zipcodes for Seattle, WA
     * using GET https://api.zippopatam.us/us/wa/seattle
     * and return List<String></String>
     *
     * Write a parameterized test to test each zipcode in Seattle, WA
     * using GET https://api.zippopatam.us/us/us/{zip}
     */

    @BeforeAll
    public static void init() {
        baseURI = "https://api.zippopatam.us";
        basePath = "/us";
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }
}
