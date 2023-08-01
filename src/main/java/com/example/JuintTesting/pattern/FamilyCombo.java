package com.example.JuintTesting.pattern;

public class FamilyCombo extends combos{
    @Override
    void comboDetails() {
        regularOrders.add(new Meals());
        regularOrders.add(new Beverages());
    }
}
