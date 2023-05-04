package com.example.JuintTesting;

import com.example.JuintTesting.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorTest {

    Calculator cal = new Calculator();

    @Test
    @DisplayName("Add")
    public void add(){
        Assertions.assertNotEquals(78 , cal.add(2,2));
    }

    @Test
    @DisplayName("assertArray")
    public void assertArray(){
        Assertions.assertArrayEquals(new int[]{1,2,3} , new int[]{1,2,3});
    }

    @Test
    @DisplayName("assertIterable")
    public void assertIterable(){
        Iterable<Integer> t1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        Iterable<Integer> t2 = new ArrayList<>(Arrays.asList(1,2,3,4));
        Assertions.assertIterableEquals(t1, t2);
    }

    @Test
    @DisplayName("assertNotNull")
    public void assertNotNull(){
        String s1 = null;
        String s2 = "abc";
        Assertions.assertNull(s1);
        Assertions.assertNotNull(s2);
    }

    @Test
    @DisplayName("assertTrueFalse")
    public void assertTrueFalse(){
        boolean s1 = true;
        boolean s2 = false;
        Assertions.assertTrue(s1);
        Assertions.assertFalse(s2);
    }

    @Test
    @DisplayName("assertTrueFalse")
    public void assertThrow(){
        Assertions.assertThrows(ArithmeticException.class , () -> cal.div(1, 0));
    }
}
