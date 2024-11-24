package com.yahya.day4;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanPutPatch extends SpartanTestBase {

    /**
     * PUT /spartans/{id}
     * content type is json
     * body is
     * {
     *     "name": "Updated123",
     *     "gender": "Male",
     *     "phone": 9999999999
     * }
     * expect status 204
     */
    @Test
    public void testUpdate(){

        String updatedBody = "{\n" +
                "    \"name\": \"Updated123\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"phone\": 9999999999\n" +
                "}";

        given().log().all()
                .pathParam("id", 93)
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .when().put("spartans/{id}")
                .then().log().all()
                .statusCode(equalTo(204));

    }

    /**
     * PATCH /spartans/{id}
     * content type is json
     * body is
     * {
     *     "name": "Updated Name",
     * }
     * expect status 204
     */

    @Test
    public void testPartialUpdate(){

        String updatedBody = "{\"name\": \"Updated Name\"}";

        given().log().all()
                .pathParam("id", 93)
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .when().patch("spartans/{id}")
                .then().log().all()
                .statusCode(equalTo(204));

    }
}
