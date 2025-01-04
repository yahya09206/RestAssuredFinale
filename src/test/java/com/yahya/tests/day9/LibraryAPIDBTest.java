package com.yahya.tests.day9;

import com.yahya.utility.DB_Util;
import com.yahya.utility.LibraryAPI_BaseTest;
import com.yahya.utility.LibraryAPI_Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LibraryAPIDBTest extends LibraryAPI_BaseTest {

    @Test
    public void test() {
        DB_Util.runQuery("SELECT * FROM books");
        DB_Util.displayAllData();
    }

    @DisplayName("Test GET /Dashboard response matches with database")
    @Test
    public void testDashboardStatsMatchDB(){

        DB_Util.runQuery("SELECT count(*) FROM books");
        DB_Util.displayAllData();
        String expectedBookCount = DB_Util.getCellValue(1, 1);

        System.out.println("users");
        DB_Util.runQuery("SELECT COUNT(*) FROM users");
        DB_Util.displayAllData();
        String expectedUserCount = DB_Util.getCellValue(1, 1);

        System.out.println("borrowed books");
        DB_Util.runQuery("SELECT COUNT(*) FROM book_borrow WHERE IS_RETURNED = 0");
        DB_Util.displayAllData();
        String expectedBorrowedBookCount = DB_Util.getCellValue(1, 1);

        /**
         * Method to return Map<String, String></String,> to return above data
         * /GET /dashboard_Stats
         */
        given().log().all().header("X-LIBRARY-TOKEN", LibraryAPI_Util.getToken()).when()
                .get("/dashboard_stats").then().log().all().statusCode(200)
                .body("book_count", is(expectedBookCount))
                .body("borrowed_books", is(expectedBorrowedBookCount))
                .body("users", is(expectedUserCount));
    }
}
