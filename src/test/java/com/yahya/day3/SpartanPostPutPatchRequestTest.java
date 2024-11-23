package com.yahya.day3;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class SpartanPostPutPatchRequestTest extends SpartanTestBase {

    @Test
    public void testAddingASpartan(){

        String strBody = "{\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"name\": \"B23 New 2024\",\n" +
                "    \"phone\": 1231234123\n" +
                "}";

        given().log().all().contentType(ContentType.JSON)
                .body(strBody)
                .when().post("/spartans")
                .then().log().all()
                .statusCode(201);

    }
}
