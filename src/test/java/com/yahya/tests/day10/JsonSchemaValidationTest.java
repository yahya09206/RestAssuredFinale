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

        given().pathParam("id", 93).log().uri()
                .when().get("/spartans/{id}")
                .then().log().all().statusCode(200)
                .body(matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));
    }
}
