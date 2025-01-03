package com.yahya.tests.day9;

import com.yahya.utility.DB_Util;
import com.yahya.utility.LibraryAPI_BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        //DB_Util.runQuery("SELECT COUNT(*) FROM USERS");

        //DB_Util.runQuery("SELECT COUNT(*) FROM BOOK_BORROW WHERE IS_RETURNED = 0");
    }

}
