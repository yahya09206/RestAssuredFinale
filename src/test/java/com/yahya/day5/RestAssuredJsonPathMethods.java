package com.yahya.day5;

import com.yahya.utility.SpartanTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredJsonPathMethods extends SpartanTestBase {

    /*
    There are two ways to get the response and extract json data

    path("your jsonpath goes here") return type is T(generic)
    and decided by your variable data type you store

    int myId = response.path("id")

    There is a type(class) in RestAssured: JsonPath that has lots of methods to extract json body
    from the response; getInt, getString, getDouble, getObject, getList and so on....
    In order to get JsonPath object our of response
    we call a method called jsonPath() from the response
    for example
     */
    // Send request to GET /spartans/{id}
    // and extract the data id, name, phone
    @Test
    public void testOneSpartan(){

        // get first id that exist on server to avoid non-existent data
        int firstId = get("/spartans").path("id[0]");
        System.out.println("firstId = " + firstId);

        // Send request to GET /spartans/{id}
        Response response = given()
                .log().uri()
                .pathParam("id", firstId).
        when()
                .get("spartans/{id}").prettyPeek();

        // save the id from the response
        // int myId = response.path("id");

        JsonPath jsonPath = response.jsonPath();
        int myId = jsonPath.getInt("id");
        String myName = jsonPath.getString("name");
        long myPhone = jsonPath.getLong("phone");

        System.out.println("myId = " + myId);
        System.out.println("myName = " + myName);
        System.out.println("myPhone = " + myPhone);

    }
}
