import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ObjectInfo {

    public static void printAdr(Object o) {
        System.out.println("printing adr: "+ o.hashCode());
    }

    public static Set<String> showMethods(Object o, boolean showAll) {
        Method[] methods;
        if (showAll) {
            methods = o.getClass().getMethods();
        }
        else {
            methods = o.getClass().getDeclaredMethods();
        }

        Set<String> stringSet = new HashSet<>();
        for (Method method : methods) {
            stringSet.add(method.getName());
//            System.out.println(method.getName());
        }
        return stringSet;
    }

    public static Set<String> showInheritedMethods(Object o) {
        Set<String> classMethods = showMethods(o, false);
        Set<String> allMethods = showMethods(o, true);

        allMethods.removeAll(classMethods);
//        for (String s : allMethods) {
//            System.out.println(s);
//        }
        return allMethods;
    }

    public static void showFields(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public static void showSuperClass(Object o) {
        System.out.println(o.getClass().getSimpleName() +" -> "+o.getClass().getSuperclass().getSimpleName());
    }
}
