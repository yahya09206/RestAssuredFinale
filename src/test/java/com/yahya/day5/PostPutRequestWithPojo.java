package com.yahya.day5;

import com.yahya.pojo.Spartan;
import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class PostPutRequestWithPojo extends SpartanTestBase {

    /*
      POST /spartans
      content type is json
      body is
      {
          "name": "API POST",
          "gender": "Male",
          "phone": 1231234123
      }



      given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap).
                when()
                .post("/spartans")
        .then()
                .log().all()
                .statusCode(201);
     */

    @Test
    public void testPostWithPOJOasBody(){

        Spartan spartan = new Spartan("B23 POJO", "Male", 5555555555L);
        System.out.println("spartan = " + spartan);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(spartan).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201);
    }
}
