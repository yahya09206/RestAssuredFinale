package com.yahya.tests.day10;

import com.yahya.utility.SpartanTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class JsonSchemaValidationTest extends SpartanTestBase {

    @DisplayName("Testing GET /spartan{id} response schema")
    @Test
    public void testSingleSpartanSchema(){

        // generalize without having to use a specific id
        int firstIdInApp = get("/spartans").path("id[-1]");

        given().pathParam("id", firstIdInApp).log().uri()
                .when().get("/spartans/{id}")
                .then().log().all().statusCode(200)
                .body(matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));
    }
}
