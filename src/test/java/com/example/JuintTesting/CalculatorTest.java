package com.example.JuintTesting;

import com.example.JuintTesting.calculator.Calculator;
import com.example.JuintTesting.calculator.Student;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorTest {

    Calculator cal = new Calculator();

    @Nested
    class Addition{
        @Test
        @DisplayName("Add")
        public void add(){
            Assertions.assertNotEquals(78 , cal.add(2,2) , () -> "Throwing error in addition");
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
        @RepeatedTest(3)
        public void assertNotNull(){
            String s1 = null;
            String s2 = "abc";
            Assertions.assertNull(s1);
            Assertions.assertNotNull(s2);
        }
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
        Assumptions.assumeTrue(false);
        Assertions.assertThrows(ArithmeticException.class , () -> cal.div(1, 0));
    }

    @Test
    @DisplayName("assertAll")
    public void assertAll(){
        Assertions.assertAll(
                    () -> Assertions.assertEquals(4 , cal.add(2,2)),
                    () -> Assertions.assertEquals(3 , cal.add(-1,4)),
                    () -> Assertions.assertEquals(-4 , cal.add(-2,-2)),
                    () -> Assertions.assertNotEquals(78 , cal.add(2,2))
                );
    }

    @EnabledOnOs(OS.MAC)
    @Test
    @DisplayName("assertEqual")
    public void assertEqual(){
        Student s1 = new Student(1l, "a","aaa");
        Assertions.assertSame(s1 , s1);
    }
}
