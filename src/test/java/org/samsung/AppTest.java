package org.samsung;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
       int number = 11;
       boolean expected = true;
       boolean actual = App.isPrimeNumber(number);
       assertEquals(expected, actual);
    }
    @Test
    public void shouldCatchException() {
        int number = -111;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> App.isPrimeNumber(number));
        assertEquals("Number is negative", exception.getMessage());
    }
    @Test
    public void shouldAnswerWithFalse() {
        int number = 8;
        boolean expected = false;
        boolean actual = App.isPrimeNumber(number);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void csvTest(String str) {
        assertThat(str, Matchers.notNullValue());
    }
}
