package com.yahya.day5;

import com.github.javafaker.Faker;
import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostRequestWithObjectTest extends SpartanTestBase {


    /**
     * Serialization: Converting from Java object to json(or any other text)
     *
     * De-Serialization: Process of Converting from Json(any text) to Java Object
     * POST /spartans
     * content type is json
     * body is
     * {
     *     "gender": "Female",
     *     "name": "B23 ADD DATA-2",
     *     "phone": 1231234123
     * }
     * Instead of providing above body in string format
     * We want to be able to provide body as a java object(Like map or POJO)
     * and let any kind of Serialization library convert that into a string for us while sending the req
     */
    @Test
    public void testPostWithMap(){

        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", "API POST");
        bodyMap.put("gender", "Male");
        bodyMap.put("phone", "1231231231");

        System.out.println("bodyMap = " + bodyMap);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap).
                when()
                .post("/spartans")
        .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    public void testPostWithMapAndRandomData(){

        Faker faker = new Faker();

        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", faker.name().firstName());
        bodyMap.put("gender", faker.demographic().sex());
        bodyMap.put("phone", faker.number().numberBetween(5000000000L, 9999999999L));

        System.out.println("bodyMap = " + bodyMap);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap).
                when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(201);
    }
}
