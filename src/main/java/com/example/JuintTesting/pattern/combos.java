package com.example.JuintTesting.pattern;

import java.util.ArrayList;
import java.util.List;

public abstract class combos {

    List<RegularOrders> regularOrders = new ArrayList<>();

    public combos(){
        comboDetails();
    }
    abstract void comboDetails();

    public void print(){
        for(int i= 0 ; i < regularOrders.size();i++){
            regularOrders.get(i).print();
        }
    }
}
