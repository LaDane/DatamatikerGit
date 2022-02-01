/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usaw
 */
class Main {

    static String greet(String s) {
        if (s == null) { return "Hello, my friend."; }
        if (s.toUpperCase().equals(s)) { return "HELLO "+ s +"!"; }
        return "Hello, "+ s +".";
    }

    static String greet(String[] names) {
        String s = "Hello, ";

        for (int i = 0; i < names.length; i++) {
            if (i == names.length - 1) {
                s = s.substring(0, s.length() - 2);
                
                if (names.length > 2)
                    s = s + ",";

                s = s + " and " + names[i] + ".";
                break;
            }
            s = s + names[i] + ", ";
        }
        
        return s;
    }
    
}
