package com.yahya.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class TestOneSpartan {

    @Test
    public void getOneSpartan(){

        Response response = get("http://44.211.192.252:8000/api/spartans/21");
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
}
