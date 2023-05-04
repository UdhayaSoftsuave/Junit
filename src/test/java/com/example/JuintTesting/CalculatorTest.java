package com.example.JuintTesting;

import com.example.JuintTesting.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator cal = new Calculator();

    @Test
    @DisplayName("Add")
    public void add(){
        Assertions.assertEquals(4 , cal.add(2,2));
    }
}
