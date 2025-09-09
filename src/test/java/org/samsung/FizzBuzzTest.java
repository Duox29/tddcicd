package org.samsung;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {
    @Test
    @Order(3)
    @Tag("g1")
    public void testFizzBuzzTrue() {
        int number = 5;
        List<String> list = Arrays.asList("1","2","Fizz","4","Buzz");
        assertEquals(list, FizzBuzz.FizzBuzz2(number));
    }

    @Test
    @Order(1)
    @Tag("g1")
    public void testFizzBuzzFalse() {
        int number = 5;
        List<String> list = Arrays.asList("1","2","Fizz","4","Buzz");
        assertNotEquals(list, FizzBuzz.FizzBuzz(number),"Shouldnt be equal");
    }
    @Test
    @Order(2)
    @Tag("g2")
    public void FbshouldCatchException() {
        int number = -111;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> FizzBuzz.FizzBuzz(number));
        assertEquals("Number must be a positive integer", exception.getMessage());
    }

    @Test
    public void testHamcrest()
    {
        MatcherAssert.assertThat(true, Matchers.equalTo(true));
    }
    @Test
    public void testHamcrest1()
    {
        List<Integer> arr = Arrays.asList(1,2,3,4,5);
        //MatcherAssert.assertThat(arr, Matchers.containsInAnyOrder(arr2));
        MatcherAssert.assertThat(arr, Matchers.everyItem(Matchers.greaterThan(0)));
    }
}
