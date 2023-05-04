package com.example.JuintTesting;

import org.junit.jupiter.api.*;
public class DemoTest {

    @AfterEach
    void afterEach(){
        System.out.println("AfterEach executed!!");
    }

    @Test
    @DisplayName("test1 Exec")
    public void test1(){
        String value = "Hello World!!";
        Assertions.assertEquals("Hello World!!" , value);
    }

    @Test
    @DisplayName("test2 Exec")
    public void test2(){
        String value = "Hello World!!";
        Assertions.assertEquals("Hello World!!" , value);
    }
}
