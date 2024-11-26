package com.yahya.day6;

import com.yahya.pojo.MoviePOJO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class MovieAPI_Test {

    @BeforeAll
    public static void setup(){
        baseURI = "http://www.omdbapi.com";
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @Test
    public void testMovies(){

        JsonPath jsonPath = given()
                .log().uri()
                .queryParam("apikey", "f90e5bb4")
                .queryParam("s", "The Mandalorian").
                when().get("").prettyPeek()
                .jsonPath();

        jsonPath.getObject("Search[0]", MoviePOJO.class);
    }
}
