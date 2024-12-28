package com.yahya.day6;

import com.yahya.utility.HrORDSTestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class HR_ORDS_Test extends HrORDSTestBase {

    // Send GET to /jobs
    @Test
    public void testJobs(){

        JsonPath jsonPath = given().log().uri().when().get("/jobs").prettyPeek().jsonPath();
    }
}
