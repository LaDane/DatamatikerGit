package com.example.shoppinglistwebsite;

public class Helpers {
    public static Boolean checkStringToInt(String stringInt) {
        try {
            convertIntToString(stringInt);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static int convertIntToString(String stringInt) {
        return Integer.parseInt(stringInt);
    }
}
