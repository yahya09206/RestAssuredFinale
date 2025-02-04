package com.yahya.tests.day5;

import com.yahya.pojo.SpartanWithID;
import com.yahya.utility.SpartanTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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

        // store json object into a Map object
        // the path to get entire body is an empty string
        // no need for a path to navigate to this json
        Map<String, Object> responseBodyAsMap = jsonPath.getMap("");
        System.out.println("responseBodyAsMap = " + responseBodyAsMap);

    }

    @Test
    public void testSearchToExtractData(){

        Response response = given().log().uri().
                                    queryParam("nameContains", "Ea").
                                    queryParam("gender", "Male").
                when().get("/spartans/search").prettyPeek();
        JsonPath jsonPath = response.jsonPath();
        System.out.println("jsonPath.getInt(\"totalElement\") = " + jsonPath.getInt("totalElement"));
        System.out.println("jsonPath.getLong(\"content[2].phone\") = " + jsonPath.getLong("content[2].phone"));
        System.out.println("jsonPath.getString(\"content[-1].name\") = " + jsonPath.getString("content[-1].name"));

        Map<String, Object> responseBodyAsMap = jsonPath.getMap("content[0]");
        System.out.println("responseBodyAsMap = " + responseBodyAsMap);

        //List<String> allNames = jsonPath.getList("content.name");
        // This version gives the option to specify the class type you want each item to have as List item
        List<String> allNames = jsonPath.getList("content.name", String.class);
        System.out.println("allNames = " + allNames);

        List<Long> allNumbers = jsonPath.getList("content.phone", Long.class);
        System.out.println("allNumbers = " + allNumbers);

        // store first json in the result as SpartanWithID POJO
        SpartanWithID sp1 = jsonPath.getObject("content[0]", SpartanWithID.class);
        System.out.println("sp1 = " + sp1);

        List<SpartanWithID> allSpartans = jsonPath.getList("content", SpartanWithID.class);
        System.out.println("allSpartans = " + allSpartans);
    }


}
