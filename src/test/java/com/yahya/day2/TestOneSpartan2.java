package com.yahya.day2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class TestOneSpartan2 {

    /**
     * BaseURI: http://44.211.192.252:8000
     * BasePath: /api
     * Anything comes after actual resources
     *
     * For RestAssured the whole URL will be BaseURI + BasePath + whatever you put in get("here")
     */
    @BeforeAll
    public static void setup(){

        baseURI = "44.211.192.252:8000";
        basePath = "/api";
    }

    @Test
    public void getOneSpartan(){

        Response response = get("spartans/21");
        System.out.println("response.statusCode() = " + response.statusCode());

        response.prettyPrint();

        System.out.println("response.asString() = " + response.asString());

        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));

        System.out.println("response.getHeader(\"Content-Type\") = " + response.getHeader("Content-Type"));

        System.out.println("response.header(\"Date\") = " + response.header("Date"));
        System.out.println("response.header(\"Keep-Alive\") = " + response.header("Keep-Alive"));
        System.out.println("response.header(\"Connection\") = " + response.header("Connection"));

    }

    @Test
    public void testContentTypeHeader(){

        Response response = get("http://44.211.192.252:8000/api/spartans/21");
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.getContentType() = " + response.getContentType());

        //Assertion to verify content type
        Assertions.assertEquals("application/json", response.contentType());

        // Different type of content type is represented in Enum
        System.out.println("ContentType.JSON = " + ContentType.JSON);
        System.out.println("ContentType.XML = " + ContentType.XML);
        System.out.println("ContentType.URLENC = " + ContentType.URLENC);
        System.out.println("ContentType.TEXT = " + ContentType.TEXT);

        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());

    }

    @Test
    public void testJSONBody(){

        Response response = get("http://44.211.192.252:8000/api/spartans/21");
        response.prettyPrint();

        // can navigate thru json to get certain element
        // the easiest way is to get value using jsonpath is using path method from response object
        System.out.println("response.path(\"id\") = " + response.path("id"));
        System.out.println("response.path(\"name\") = " + response.path("name"));
        System.out.println("response.path(\"gender\") = " + response.path("gender"));
        System.out.println("response.path(\"phone\") = " + response.path("phone"));

        /**
         * {
         *     "id": 21,
         *     "name": "Mark",
         *     "gender": "Male",
         *     "phone": 1852873386
         * }
         */
        // save the json value we get from the key into variables
        int myId = response.path("id");
        String myName = response.path("name");
        String myGender = response.path("gender");
        int myPhone = response.path("phone");

        System.out.println("myId = " + myId);
        System.out.println("myName = " + myName);
        System.out.println("myGender = " + myGender);
        System.out.println("myPhone = " + myPhone);


        Assertions.assertEquals(21, myId);
        Assertions.assertEquals("Mark", myName);
        Assertions.assertEquals("Male", myGender);
        Assertions.assertEquals(1852873386, myPhone);
    }
}
