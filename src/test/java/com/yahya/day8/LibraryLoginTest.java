package com.yahya.day8;

import com.yahya.utility.LibraryAPI_BaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.*;

public class LibraryLoginTest extends LibraryAPI_BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/LibraryCredentials.csv", numLinesToSkip = 1)
    public void testLogin(String username, String password) {

        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }

}
