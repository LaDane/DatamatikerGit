import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

// Polymorph

public class Main {
    public static void main(String[] args) {
        /*
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

//        String answer = getInput("What object do you want?");
//        Object object;
//        switch (answer){
//            case "cat":
//                object = new Cat();
//                break;
//            case "cow":
//                object = new Cow();
//                break;
//            case "string":
//                object = "";
//                break;
//            default:
//                object = new Object();
//        }
//        ObjectInfo.showSuperClass(object);

        ObjectInfo objectInfo = new ObjectInfo();
        System.out.println("\nAll methods");
        Set<String> sortedMethods = ObjectInfo.showMethods(objectInfo, false);
        TreeSet<String> sortedMethodsTree = new TreeSet<>(sortedMethods);
        for (String sortedMethod : sortedMethodsTree) {
            System.out.println("\t"+ sortedMethod);
        }

        System.out.println("\nInherited Methods");
        Set<String> sortedInheritedMethods = ObjectInfo.showInheritedMethods(objectInfo);
        TreeSet<String> sortedInheritedMethodsTree = new TreeSet<>(sortedInheritedMethods);
        for (String sortedMethod : sortedInheritedMethodsTree) {
            System.out.println("\t"+ sortedMethod);
        }
        */

        // Another example of polymorph
//        Set<String> stringSet = new HashSet<>();
//        stringSet = new LinkedHashSet<>();
//        stringSet = new TreeSet<>();

//        Map<String, Object> stringObjectMap = new HashMap<>();
//        stringObjectMap.put("cow", new Cow());
//        stringObjectMap.put("cat", new Cat());
//        stringObjectMap.put("dog", new Dog());
//        stringObjectMap.put("fish", new Fish());
//        stringObjectMap.put("object", new ObjectInfo());
//
//        stringObjectMap.getOrDefault(getInput("Write a type"), new Object());

        mapIntro();

    }

    public static String getInput(String s) {
        System.out.println(s);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void mapIntro() {
        // Maps
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("cow", new Cow());
        objectMap.put("cat", new Cat());
        objectMap.put("dog", new Dog());
        objectMap.put("person", new Person("Alek", 25));
        objectMap.put("objectInfo", new ObjectInfo());
        objectMap.put("map", new HashMap<>());
        objectMap.put("tree", new TreeSet<>());
        objectMap.put("div", new ArithmeticException());

//        System.out.println(objectMap.getOrDefault(getInput("Input object type\n"), new Object()).getClass().getSimpleName());
//        System.out.println(ObjectInfo.showInheritedMethods(objectMap.getOrDefault(getInput("Input object type\n"), new Object())));
//        System.out.println("\nAll classes in map");
//        for (String s : objectMap.keySet()) {
//            System.out.println(s);
//        }
//        System.out.println("\nAll objects in map");
//        for (Object value : objectMap.values()) {
//            System.out.println(value.getClass().getSimpleName());
//        }

//        ObjectInfo.showClassHierarchy(objectMap);
        ObjectInfo.showReverseClassHierarchy(objectMap);
    }

}
