package com.yahya.day8;

import com.yahya.utility.SpartanAuthTestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class BaseAuthTest extends SpartanAuthTestBase {

    /**
     * Send a request to GET /spartans without any authentication
     * expect 401
     */
    @Test
    public void testWithoutAuth(){

        given().log().uri()
                .when().get("/spartans").then().log().all().statusCode(401);
    }

    /**
     * Send a request to GET /spartans with authentication
     * expect 200
     */



}
