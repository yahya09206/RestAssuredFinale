package com.yahya.day2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class TestSpartan3 {

    @BeforeAll
    public static void setup(){

        baseURI = "http://44.211.192.252:8000";
        basePath = "/api";
    }

    @AfterAll
    public static void tearDown(){

        /**
         * In order to avoid the static value being accidentally carried over
         * to a different class when we do a different api
         * it's better if we set baseURI basePath back to its original value using reset method
         * RestAssured.reset();
         */
        reset();
    }

    @Test
    public void testAllSpartans(){

        Response response = get("/spartans");
        // response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());

        // get to body --> id or name or gender or phone
        System.out.println("response.path(\"[0].gender\") = " + response.path("[0].gender"));
        System.out.println("response.path(\"gender[0]\") = " + response.path("gender[0]"));

        /**
         * Get all the ids and store them into a List<Integer></Integer>
         */
        List<Integer> idList = response.path("id");
        System.out.println("idList = " + idList);
    }

    /**
     * Send request to GET /spartans and provide accept header as application/xml
     * and check status code 200 and content type application xml
     */
    @Test
    public void testGetXMLResponse(){

        /**
         * RestAssured uses method chaining extensively to combine all parts of the request
         * and verify the response in one shot
         * here since we need to provide additional header information to get xml response
         * we will start learning some method chaining to see
         * how we can provide additional information to the request
         */
        Response response = given().//header("Accept", "application/xml").
                            accept(ContentType.XML).
                            when().get("/spartans");

        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(ContentType.XML.toString(), response.contentType());
    }

    @Test
    public void testSearch(){

        Response response = given()
                .queryParam("nameContains", "Ea")
                .queryParam("gender", "Male")
                .when().get("/spartans/search");
        response.prettyPrint();


    }
}
