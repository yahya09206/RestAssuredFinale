package com.yahya.tests.day8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodSourcePracticeTest {

    // if we want more than one value for each test in parameterized test
    // List<String> will only store 1 string per element
    // in order to have more than one value
    // we can use List<Map<String, Object>>

    @ParameterizedTest
    @MethodSource("getAllStudentInfo")
    public void testStudentDDT(Map<String, Object> studentInfo) {
        System.out.println("studentInfo = " + studentInfo);
    }

    // Static method that returns List<Map<String, Object>>
    // Map object should have key: name, gender, phone
    public static List<Map<String, Object>> getAllStudentInfo(){

        List<Map<String, Object>> allInfoMapList = new ArrayList<>();
        // add 3 items to this list
        Map<String, Object> studentMapObject1 = new HashMap<>();
        studentMapObject1.put("name","Mousa");
        studentMapObject1.put("gender","Male");
        studentMapObject1.put("phone",1234567890L);

        Map<String, Object> studentMapObject2 = new HashMap<>();
        studentMapObject2.put("name","Mousa");
        studentMapObject2.put("gender","Male");
        studentMapObject2.put("phone",1234567890L);

        Map<String, Object> studentMapObject3 = new HashMap<>();
        studentMapObject3.put("name","Mousa");
        studentMapObject3.put("gender","Male");
        studentMapObject3.put("phone",1234567890L);

        allInfoMapList.add(studentMapObject1);
        allInfoMapList.add(studentMapObject2);
        allInfoMapList.add(studentMapObject3);

        return allInfoMapList;
    }
}
