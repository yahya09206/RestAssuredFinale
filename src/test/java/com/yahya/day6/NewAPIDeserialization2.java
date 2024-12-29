package com.yahya.day6;

import com.yahya.pojo.Article;
import com.yahya.pojo.Article2;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class NewAPIDeserialization2 {

    /**
     * GET https://newsapi.org/v2/top-headlines?country=us
     * Header: Authorization = Bearer 0b42f37dd32d4c70911a063c275005b0
     */

    @BeforeAll
    public static void setup(){

        baseURI = "https://newsapi.org";
        basePath = "/v2";
    }

    @AfterAll
    public static void tearDown(){

        reset();
    }


    @Test
    public void testNews(){

        JsonPath jsonPath = given().log().all().queryParam("country", "us")
                .header("Authorization", "Bearer 0b42f37dd32d4c70911a063c275005b0")
                .when().get("/top-headlines")//.prettyPeek()
                .jsonPath();

        // Save first article json into Article2 pojo
        Article2 article2 = jsonPath.getObject("articles[0]", Article2.class);
        System.out.println("article2 = " + article2);
        //get source id
        System.out.println("article2.getSource().getId() = " + article2.getSource().getId());

        // find all articles where source id is not null
        List<Article2> article2s = jsonPath.getList("articles", Article2.class);

        // loop to go through articles and get authors
        for (Article2 each : article2s) {
            if (each.getSource().getId() != null){
                System.out.println("each.getSource().getId() = " + each.getSource().getId());
                System.out.println("each.getAuthor() = " + each.getAuthor());
            }
        }
    }
}
