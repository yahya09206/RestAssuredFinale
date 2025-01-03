package com.yahya.tests.day7;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
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
                .then().log().all()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
                //assert body is correct
                .body("country", is("United States"))
                .body("places[0].state", is("Washington"))
                .body("'post code'", equalTo("98146"));
    }

    @ParameterizedTest
    //@ValueSource(ints = {90210, 98146, 98118, 98101})
    @CsvFileSource(resources = "/Zipcodes.csv")
    public void testZipToCityDDT(int zipParam){
        System.out.println("zipParam = " + zipParam);
        given().log().uri().pathParam("zip", zipParam).when().get("/{zip}").then().statusCode(200);
    }
}
