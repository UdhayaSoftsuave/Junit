package com.example.JuintTesting.pattern;

public class Meals implements RegularOrders{
     private String name = "MEALS";
     private int amount = 200;
    @Override
    public void print() {
        System.out.println("The Order name : " + name + " amount : "+ amount);
    }
}
