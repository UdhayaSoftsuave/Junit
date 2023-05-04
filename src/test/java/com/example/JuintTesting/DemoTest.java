package com.example.JuintTesting;

import org.junit.jupiter.api.*;
public class DemoTest {

    @BeforeEach
    void beforeAll(){
        System.out.println("BeforeAll executed!!");
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
