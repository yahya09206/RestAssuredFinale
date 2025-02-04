package com.yahya.tests.day9;

import com.yahya.utility.ConfigReader;
import com.yahya.utility.DB_Util;
import com.yahya.utility.HrORDSTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class API_DB_Test extends HrORDSTestBase {

    @DisplayName("Test Region Count with API from Database")
    @Tag("db")
    @Test
    public void Region(){

        DB_Util.runQuery("SELECT * FROM REGIONS");
        DB_Util.displayAllData();
    }

    @Test
    public void testRegionsCount(){
        DB_Util.runQuery("SELECT * FROM REGIONS");
        int expectedCount = DB_Util.getRowCount();

        given().log().uri().
        when()
                .get("/regions").
                then()
                    .log().ifValidationFails().statusCode(200)
                .body("count", is(expectedCount))
                .body("items", hasSize(expectedCount));
    }

    /**
     * Send request to GET /regions/{region_id} region_id = 1
     * prepare expected result from the database by running
     * SELECT * FROM REGIONS WHERE REGION_ID = 1
     * Save the result of query as Map
     * then verify the region_id and region_name match between api and db response
     */
    @Test
    public void testSingleRegion(){

        DB_Util.runQuery("SELECT * FROM REGIONS WHERE REGION_ID = 1");
        Map<String, String> dbResultMap = DB_Util.getRowMap(1);
        System.out.println("dbResultMap = " + dbResultMap);

        int expectedRegionID = Integer.parseInt(dbResultMap.get("REGION_ID"));
        String expectedRegionName = dbResultMap.get("REGION_NAME");

        given().pathParam("region_id", 1).log().uri()
                .when().get("/regions/{region_id}")
                .then().log().all().statusCode(200)
                .body("region_id", equalTo(expectedRegionID))
                .body("region_name", equalTo(expectedRegionName));

    }

    /**
     * Parameterized test to get all regionas instead of just one
     * a coupel of different ways
     * 1. @ValueSource to provide all 4 region ids
     * 2. @MethodSource
     *   -- get all ids from api response GET /regions and return List<Integer></Integer>
     * 3. @MethodSource
     *   -- get all ids from SELECT * FROM REGIONS QUERY and return List<String></String>
     *   and use it as a source
     */
}
