package com.yahya.tests.day9;

import com.yahya.utility.ConfigReader;
import com.yahya.utility.DB_Util;
import com.yahya.utility.HrORDSTestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class API_DB_Test extends HrORDSTestBase {

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
                .body("count", is(expectedCount));
    }
}
