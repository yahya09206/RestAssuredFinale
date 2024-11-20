package com.yahya.day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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

    }
}
