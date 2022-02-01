package facades;

import static org.junit.jupiter.api.Assertions.*;

public class FacadeTest {
    private static MyClass instance;
    
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
        instance = new MyClass();
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    public void myTest() {
        String expected = "Hello";
        String actual = instance.myMethod();
        assertEquals(actual, expected);
    }
}
