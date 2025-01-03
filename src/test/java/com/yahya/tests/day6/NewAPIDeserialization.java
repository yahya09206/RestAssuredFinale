package com.yahya.tests.day6;

import com.yahya.pojo.Article;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class NewAPIDeserialization {

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
                .when().get("/top-headlines").prettyPeek().jsonPath();

        //Get first article using pojo
        Article article = jsonPath.getObject("article[0]", Article.class);
        System.out.println("article = " + article);

        // check if source id is null or not
        //System.out.println("article.getSource().get(\"id\") = " + article.getSource().get("id"));

        // Get list of articles
        List<Article> allArticles = jsonPath.getList("articles", Article.class);
        for (Article allArticle : allArticles) {
            if (allArticle.getSource().get("id") != null) {
                System.out.println(allArticle.getAuthor());
            }
        }
    }
}
