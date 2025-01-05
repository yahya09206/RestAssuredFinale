package com.yahya.tests.day11;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

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

    @DisplayName("Test GET /drivers/driver{id} xml response")
    @Test
    public void testSingleDriverXMLResponse(){

        given()
                .pathParam("driverId", "abate")
                .log().uri()
                .when().get("/drivers/{driverId}")
        .then()
                .log().all().statusCode(200)
                .contentType(ContentType.XML);
    }
}
