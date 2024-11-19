package com.yahya.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class TestSpartanAPI {

    @Test
    public void testHello(){
        System.out.println("Hello world");

        //Send request to below url and save the response
        // get method is coming from RestAssured class to send get request to the url defined
        // store request in response object
        Response response = get("http://44.211.192.252:8000/api/hello");
        System.out.println("response.statusCode() = " + response.statusCode());


    }
}
