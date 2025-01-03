package com.yahya.tests.day8;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

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
        baseURI = "https://api.zippopotam.us";
        basePath = "/us";
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @ParameterizedTest
    @MethodSource("getAllZipcodes")
    public void testAllZipcodes(String zipcode){
        System.out.println("zipcode = " + zipcode);

        given().
                log().uri().
                pathParam("zip", zipcode).
                when().
                get("/{zip}").
                then().
                statusCode(200);
    }

    public static List<String> getAllZipcodes(){

        // Send GET https://api.zippopatam.us/us/wa/seattle and store all of the zipcodes
        // since this is not a @Test method, @BeforeAll will not affect this
        // and baseURI and basePath will not be set so we need to do it ourselves
        // one way to do this is to provide full url directly
        List<String> allZipcodes = get("https://api.zippopotam.us/us/va/fairfax")
                .path("places.'post code'");

        return allZipcodes;
    }
}
