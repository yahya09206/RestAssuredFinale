package com.yahya.day5;

public class PostPutRequestWithPojo {

    /*
      POST /spartans
      content type is json
      body is
      {
          "name": "API POST",
          "gender": "Male",
          "phone": 1231234123
      }
      Another common way of representing json data is using special purpose Java Object created from A class
      that have fields matched to json keys
      and have getters and setters
      This type of Object, sole purpose is to represent data
      known as POJO, plain old java object
      The class to create POJO known as POJO class
      it's used for creating pojo, just like you would create any other object

      In order to represent a json data with 3 keys name, gender, phone we can create a java class
      with 3 instance fields with some names

      given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap).
                when()
                .post("/spartans")
        .then()
                .log().all()
                .statusCode(201);
     */





}
