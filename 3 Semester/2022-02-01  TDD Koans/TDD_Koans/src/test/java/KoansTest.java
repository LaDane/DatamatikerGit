/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author usaw
 */
public class KoansTest {
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    // Requirement 1
    @Test
    public void greetTest() {
        System.out.println("greet");
        String name = "Bob";
        String expected = "Hello, Bob.";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    
    // Requirement 2
    @Test
    public void handleNullTest() {
        System.out.println("handle null");
        String name = null;
        String expected = "Hello, my friend.";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    
    // Requirement 3
    @Test
    public void handleShoutTest() {
        System.out.println("handle shout");
        String name = "BOB";
        String expected = "HELLO BOB!";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    
    // Requirement 4
    @Test
    public void nameArrayTest() {
        System.out.println("name array");
        String[] names = {"Bob", "Jim"};
        String expected = "Hello, Bob and Jim.";
        String actual = Main.greet(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 5
    @Test
    public void nameArrayLargeTest() {
        System.out.println("name array large");
        String[] names = {"Bob", "Jim", "Brian"};
        String expected = "Hello, Bob, Jim, and Brian.";
        String actual = Main.greet(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 6
    @Test
    public void nameArrayShoutTest() {
        System.out.println("name array shout");
        String[] names = {"Bob", "JIM", "Brian"};
        String expected = "Hello, Bob and Brian. AND HELLO JIM!";
        String actual = Main.greet(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 7
    @Test
    public void nameArrayCommaTest() {
        System.out.println("name array comma");
        String[] names = {"Bob", "Charlie, Dianne"};
        String expected = "Hello, Bob, Charlie, and Dianne.";
        String actual = Main.greet(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 8
    @Test
    public void nameArrayDoubleQuiteTest() {
        System.out.println("name array double quote");
        String[] names = {"Bob", "\"Charlie, Dianne\""};
        String expected = "Hello, Bob and Charlie, Dianne.";
        String actual = Main.greet(names);
        assertEquals(expected, actual);
    }
}
