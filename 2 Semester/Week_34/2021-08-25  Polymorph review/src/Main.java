import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String s = "hi";
        String s1 = new String("palle");
        String s2 = "hi";

        System.out.println("Value of s is = "+ s.hashCode());
        System.out.println("Value of s2 is = "+ s2.hashCode());
        // These memory addresses are the same,

        s = "I love cake";
        System.out.println("Value of s is now = "+ s.hashCode() +"\n");
        // When updating a variable, the memory address changes

        Object[] objects = {new Car(), new Hippo(), new Deer(), new Dog()};
        for (Object object : objects) {
            if (object instanceof Car) {
                ((Car) object).drive();
            }
            else if (object instanceof Hippo) {
                ((Hippo) object).jump();
            }
            else if (object instanceof  Deer) {
                ((Deer) object).sound();
            }
            else if (object instanceof Dog) {
                ((Dog) object).bark();
            }
        }

        // Long version above
        // Can be shortened to following:

        Command[] commands = {new Car(), new Hippo(), new Deer(), new Dog()};
        for (Command command : commands) {
            command.execute();
        }
    }
}
