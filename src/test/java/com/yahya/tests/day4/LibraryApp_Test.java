package com.yahya.tests.day4;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class LibraryApp_Test {

    @BeforeAll
    public static void setup(){

        RestAssured.baseURI = "https://library2.cydeo.com";
        RestAssured.basePath = "rest/v1";
    }

    @AfterAll
    public static void teardown(){
        reset();
    }

    @Test
    public void testLogin(){

        /**
         * POST /login
         * content type: application/x-www-form-urlencoded
         * body:
         *  email: librarian5@library
         *  password: libraryUser
         */

        given().log().all().contentType(ContentType.URLENC)
                .formParam("email", "librarian5@library")
                .formParam("password", "libraryUser")
                .when().post("/login")
                .then().log().all().statusCode(200);
    }

    @Test
    public void testDashboardStats(){

        Response response = given().log().all().contentType(ContentType.URLENC)
                .formParam("email", "librarian5@library")
                .formParam("password", "libraryUser")
                .when().post("/login");

        String tokenFromRes = response.path("token");
        System.out.println("tokenFromRes = " + tokenFromRes);

        given().log().all().header("x-library-token", tokenFromRes)
                .when().get("/dashboard_stats")
                .then().log().all().statusCode(200);
    }
}
