package com.yahya.tests.day9;

import com.yahya.utility.DB_Util;
import com.yahya.utility.LibraryAPI_BaseTest;
import org.junit.jupiter.api.Test;

public class LibraryAPIDBTest extends LibraryAPI_BaseTest {

    @Test
    public void test() {
        DB_Util.runQuery("SELECT * FROM books");
        DB_Util.displayAllData();
    }
}
