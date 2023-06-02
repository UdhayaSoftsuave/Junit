package com.example.gradleTest.gradleTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GradleTestApplicationTests {

//	@Test
//	void contextLoads() {
//	}
    @Test
    public void get(){
        Assertions.assertTrue(true);
    }

}
