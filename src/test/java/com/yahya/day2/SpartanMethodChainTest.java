package com.yahya.day2;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class SpartanMethodChainTest extends SpartanTestBase {

    @Test
    public void getOneSpartanTest(){

        given().log().all().pathParam("id", 21)
                .accept(ContentType.JSON)
                .when().get("/spartans/{id}")
                .then().statusCode(is(200))
                //.header("Content-Type", ContentType.JSON.toString())
                .contentType(ContentType.JSON)
                .body("id", is(21))
                .body("name", is("Mark"));

    }

    @Test
    public void testSearch(){

        given().log().all().queryParam("nameContains", "Ea")
                .queryParam("gender", "Male")
                .when().get("/spartans/search")
                .then().log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalElement", is(3))
                .body("content",hasSize(3))
                .body("content.name", hasItem("Sean"))
                .body("content.gender", everyItem(is("Male")))
                .body("content.name", everyItem(is(containsStringIgnoringCase("Ea"))));
    }
}
