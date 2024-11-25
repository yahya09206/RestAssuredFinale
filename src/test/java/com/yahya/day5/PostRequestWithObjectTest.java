package com.yahya.day5;

import com.yahya.utility.SpartanTestBase;
import org.junit.jupiter.api.Test;

public class PostRequestWithObjectTest extends SpartanTestBase {


    /**
     * Serialization: Converting from Java object to json(or any other text)
     *
     * De-Serialization: Process of Converting from Json(any text) to Java Object
     * POST /spartans
     * content type is json
     * body is
     * {
     *     "gender": "Female",
     *     "name": "B23 ADD DATA-2",
     *     "phone": 1231234123
     * }
     * Instead of providing above body in string format
     * We want to be able to provide body as a java object(Like map or POJO)
     * and let any kind of Serialization library convert that into a string for us while sending the req
     */
    @Test
    public void testPostWithMap(){


    }
}
