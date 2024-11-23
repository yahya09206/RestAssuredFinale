package com.yahya.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class HR_ORDS_API_Test {

    @BeforeAll
    public static void setup(){

        baseURI = "http://44.211.192.252:1000";
        basePath = "/ords/hr";
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
    public void testGetAllJobs(){

        Response response = given().log().all().when().get("/jobs");
        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());
        int countValue = response.path("count");
        Assertions.assertEquals(19, countValue);

        String secondJobId = response.path("Items[1].job_id");
        System.out.println("secondJobId = " + secondJobId);

        // Save all job titles into a list of string
        List<String> jobTitles = response.path("items.job_title");
        System.out.println("jobTitles = " + jobTitles);
    }
}
