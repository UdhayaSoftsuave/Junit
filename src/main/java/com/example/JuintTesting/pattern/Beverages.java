package com.example.JuintTesting.pattern;

public class Beverages implements RegularOrders{
    private String name = "BEVERAGES";
    private int amount = 100;
    @Override
    public void print() {
        System.out.println("The Order name : " + name + " amount : "+ amount);
    }
}
