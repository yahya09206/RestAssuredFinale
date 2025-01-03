package com.yahya.tests.day9;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smokeAll")
public class TaggingInJunit5Test {

    @Tag("smoke1")
    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Tag("smoke2")
    @Test
    public void test2(){
        System.out.println("Test2");
    }

    @Test
    public void test3(){
        System.out.println("Test3");
    }
}
