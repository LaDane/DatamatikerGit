import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
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

    public static void showClassHierarchy(Map<String, Object> objectMap) {
        Object o = objectMap.getOrDefault(Main.getInput("Write a class"), new Object());
        Class<?> obj = o.getClass();
        System.out.println(obj.getSimpleName());

        while(true) {
            obj = obj.getSuperclass();
            System.out.println(obj.getSimpleName());
            if (obj.getSimpleName().equals("Object")) {
                break;
            }
        }
    }

    public static void showReverseClassHierarchy(Map<String, Object> objectMap) {
        Object o = objectMap.getOrDefault(Main.getInput("Write a class"), new Object());
        ArrayList<Object> arr = new ArrayList<>();
        Class<?> obj = o.getClass();
        arr.add(obj.getSimpleName());

        while(true) {
            obj = obj.getSuperclass();
            arr.add(obj.getSimpleName());
            if (obj.getSimpleName().equals("Object")) {
                break;
            }
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.println(arr.get(i));
        }
    }
}
