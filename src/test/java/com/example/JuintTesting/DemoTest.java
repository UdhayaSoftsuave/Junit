package com.example.JuintTesting;

import org.junit.jupiter.api.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoTest {

    @AfterAll
    void afterAll(){
        System.out.println("AfterAll executed!!");
    }

    @Test
    public void test1(){
        String value = "Hello World!!";
        Assertions.assertEquals("Hello World!!" , value);
    }

    @Test
    public void test2(){
        String value = "Hello World!!";
        Assertions.assertEquals("Hello World!!" , value);
    }
}
