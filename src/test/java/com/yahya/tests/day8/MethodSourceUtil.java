package com.yahya.tests.day8;

import java.util.Arrays;
import java.util.List;

/**
 * Purpose of this class is to demonstrate providing the method source for a paramterized test
 * and the method exists outisde of the Test class
 */
public class MethodSourceUtil {

    // create a static method that returns list of names
    // so we can use the returned value as data source for our parameterized test
    public static List<String> getSomeNames(){

        return Arrays.asList("Furkan", "Abbos", "Shazia", "Tugba");
    }
}
