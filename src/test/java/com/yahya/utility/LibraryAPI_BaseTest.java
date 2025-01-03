package com.yahya.utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.reset;

public class LibraryAPI_BaseTest {

    @BeforeAll
    public static void setup(){

        RestAssured.baseURI = "https://library2.cydeo.com";
        RestAssured.basePath = "rest/v1";
        //create db connection for library
        createLibraryConnection();
    }

    public static void createLibraryConnection(){

        String url = ConfigReader.read("library2.database.url");
        String username = ConfigReader.read("library2.database.username");
        String password = ConfigReader.read("library2.database.password");
        DB_Util.createConnection(url , username, password);

    }

    @AfterAll
    public static void teardown(){
        reset();
        // destroy the db connection
        DB_Util.destroy();
    }
}
