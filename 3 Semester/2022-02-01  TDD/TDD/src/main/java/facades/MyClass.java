package facades;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class MyClass {
    public String myMethod() {
        return "Hello";
    }    
    
    public String testClass() {
        List<String> myStrings = new ArrayList<String>();
        myStrings.add("string1");
        return myStrings.get(0);
    }
}
