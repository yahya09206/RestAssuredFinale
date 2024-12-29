package com.yahya.day7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testZipToCity(){

        given()
                .log().all()
                .pathParam("zip", 98146)
                .when().get("/{zip}")
                .then().log().all();
    }


}
