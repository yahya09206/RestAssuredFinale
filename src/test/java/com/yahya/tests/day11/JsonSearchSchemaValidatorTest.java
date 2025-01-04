package com.yahya.tests.day11;

import com.yahya.utility.SpartanTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class JsonSearchSchemaValidatorTest extends SpartanTestBase {

    // http://44.211.192.252:8000/api/spartans/search?nameContains=Ea
    // when there are more than a couple of key value pairs
    // RestAssured provides methods to let you pass it as a map in one shot
    @DisplayName("Test GET /spartans/search Schema")
    @Test
    public void testSearchSchema(){
        Map<String, Object> queryMap = new LinkedHashMap<>();
        queryMap.put("nameContains", "Ea");
        queryMap.put("gender", "Male");

        given().queryParams(queryMap).when().get("/spartans/search")
                .then().statusCode(200)
                .body(matchesJsonSchemaInClasspath("SearchSpartanSchema.json"));
    }
}
