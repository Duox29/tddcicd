package org.samsung;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {
    @Test
    public void testFizzBuzzTrue() {
        int number = 5;
        List<String> list = Arrays.asList("1","2","Fizz","4","Buzz");
        String str = " 1 2 Fizz 4 Buzz";
        assertEquals(list, FizzBuzz.FizzBuzz2(number));
    }

    @Test
    public void testFizzBuzzFalse() {
        int number = 5;
        List<String> list = Arrays.asList("1","2","Fizz","4","Buzz");
        assertNotEquals(list, FizzBuzz.FizzBuzz(number));
    }
    @Test
    public void FbshouldCatchException() {
        int number = -111;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> FizzBuzz.FizzBuzz(number));
        assertEquals(exception.getMessage(), "Number must be a positive integer");
    }
}
