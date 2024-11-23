package com.yahya.day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class HamcrestMatcherTest {

    @Test
    public void testNumbers(){

        // Junit5 Assertions
        assertEquals(9, 3 + 6);

        // Hamcrest, easier to read
        assertThat(3 + 6, equalTo(9));

        assertThat(4 + 6, is(10));

        assertThat(5 + 6, greaterThan(10));

        assertThat(10 + 10, lessThanOrEqualTo(20));
    }

    @Test
    public void testString(){

        String msg = "B23 is Excellent";
        assertThat(msg, equalTo("B23 is Excellent"));
        assertThat(msg, is("B23 is Excellent"));

        assertThat(msg, startsWith("B23"));
        assertThat(msg, startsWithIgnoringCase("b23"));
    }
}
