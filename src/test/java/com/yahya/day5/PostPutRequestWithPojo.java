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
