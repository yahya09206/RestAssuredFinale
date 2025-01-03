package com.yahya.tests.day9;

import com.yahya.utility.ConfigReader;
import com.yahya.utility.DB_Util;
import com.yahya.utility.HrORDSTestBase;
import org.junit.jupiter.api.Test;

public class API_DB_Test extends HrORDSTestBase {

    @Test
    public void Region(){

        DB_Util.runQuery("SELECT * FROM REGIONS");
        DB_Util.displayAllData();
        DB_Util.destroy();
    }

}
