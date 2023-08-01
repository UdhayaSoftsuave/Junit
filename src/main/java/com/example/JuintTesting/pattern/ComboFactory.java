package com.example.JuintTesting.pattern;

public class ComboFactory {

    public combos getCombo(Combo combo){
        switch (combo){
            case FAMILY_COMBO :
                return new FamilyCombo();
            case LITE_COMBO :
                return new LiteCombo();
            default:
                return null;
        }
    }
}
