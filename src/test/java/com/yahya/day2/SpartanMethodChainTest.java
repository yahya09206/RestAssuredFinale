package com.yahya.day2;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class SpartanMethodChainTest extends SpartanTestBase {

    @Test
    public void getOneSpartanTest(){

        given().log().all().pathParam("id", 1)
                .accept(ContentType.JSON)
                .when().get("/spartans/{id}")
                .then().statusCode(is(200))
                //.header("Content-Type", ContentType.JSON.toString())
                .contentType(ContentType.JSON);
    }
}
