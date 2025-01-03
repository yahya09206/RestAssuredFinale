package com.yahya.tests.day9;

import com.yahya.utility.ConfigReader;
import com.yahya.utility.DB_Util;
import org.junit.jupiter.api.Test;

public class API_DB_Test {

    @Test
    public void Region(){

        DB_Util.createConnection(ConfigReader.read("hr.database.url"), ConfigReader.read("hr.database.username"), ConfigReader.read("hr.database.password"));
        DB_Util.runQuery("SELECT * FROM REGIONS");
        DB_Util.displayAllData();
        DB_Util.destroy();
    }
}
