package com.yahya.day6;

import com.yahya.pojo.HarryPotterPOJO;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class HarryPotterDeserialization {

    // https://hp-api.onrender.com/api/characters
    @BeforeAll
    public static void setup(){

        baseURI = "https://hp-api.onrender.com";
        basePath = "/api";
    }

    @AfterAll
    public static void tearDown(){

        reset();
    }

    @Test
    public void testCharacters(){
        JsonPath jsonPath = get("/characters").prettyPeek().jsonPath();

        HarryPotterPOJO harryPotterPOJO = jsonPath.getObject("[0]", HarryPotterPOJO.class);
        System.out.println("harryPotterPOJO = " + harryPotterPOJO);
    }
}
