import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

// Polymorph

public class Main {
    public static void main(String[] args) {
        int[] ints = new int[4];

        String s = "hej";

        Person person = new Person("Alek", 25);
        Cat cat = new Cat();
        Cow cow = new Cow();
        Dog dog = new Dog();

        Object[] objects = new Object[4];
        objects[0] = person;
        objects[1] = cat;
        objects[2] = cow;
        objects[3] = dog;

        for (Object o : objects) {
            if (o instanceof Person) {
                ((Person) o).whoAmI();
            }
            if (o instanceof Cat) {
                ((Cat) o).whoAmI();
            }
            if (o instanceof Cow) {
                ((Cow) o).whoAmI();
            }
            if ( o instanceof Dog) {
                ((Dog) o).whoAmI();
            }
            ObjectInfo.printAdr(o);
        }

        Command[] commands = new Command[6];
        commands[0] = new Cat();
        commands[1] = new Cow();
        commands[2] = new Dog();
        commands[3] = new Person("Alek", 25);
        commands[4] = new Cow();
        commands[5] = new Fish();

        System.out.println("Without discrimination");
        for (Command command: commands) {
            command.execute();
        }

        System.out.println("\nNow with array list");

        ArrayList<Command> commandArray = new ArrayList<>(Arrays.asList(commands));
        commandArray.add(new Cow());

        for (Command command : commandArray) {
            command.execute();
        }

        System.out.println("\nLets try printing the addresses");
        for (Command command : commandArray) {
            ObjectInfo.printAdr(command);
        }

        System.out.println("\nLets print object method names");
        for (Command command : commandArray) {
            ObjectInfo.showMethods(command, false);
        }

        System.out.println("\nLets print object variable names");
        for (Command command : commandArray) {
            ObjectInfo.showFields(command);
        }

        System.out.println("\nLets print super class name");
        for (Command command : commandArray) {
            ObjectInfo.showSuperClass(command);
        }

//        System.out.println("You wrote : "+ getInput("\nWrite something\n"));

        String answer = getInput("What object do you want?");
        Object object;
        switch (answer){
            case "cat":
                object = new Cat();
                break;
            case "cow":
                object = new Cow();
                break;
            case "string":
                object = "";
                break;
            default:
                object = new Object();
        }
        ObjectInfo.showSuperClass(object);

    }

    public static String getInput(String s) {
        System.out.println(s);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
