package com.yahya.utility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class LibraryAPI_Util {

    public static String getToken(){

        return given()
                .contentType(ContentType.URLENC)
                .formParam("email" , "librarian5@library")
                .formParam("password" , "libraryUser").
                when()
                .post("/login").path("token") ;


    }
}
