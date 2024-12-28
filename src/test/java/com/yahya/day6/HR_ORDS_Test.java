package com.yahya.day6;

import com.yahya.pojo.Jobs;
import com.yahya.utility.HrORDSTestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class HR_ORDS_Test extends HrORDSTestBase {

    // Send GET to /jobs
    @Test
    public void testJobs(){

        JsonPath jsonPath = given().log().uri().when().get("/jobs").prettyPeek().jsonPath();

        // De-serialize first json object from json array
        // we want to be able to follow java naming convention for pojo fields
        // ignore the json fields we don't need
        Jobs jobs1 = jsonPath.getObject("items[0]", Jobs.class);
        System.out.println("jobs1 = " + jobs1);

        // save all jobs into a List<jobs>
        List<Jobs> allJobs = jsonPath.getList("items", Jobs.class);
        System.out.println("allJobs = " + allJobs);
    }
}
