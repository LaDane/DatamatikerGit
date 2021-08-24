import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectInfo {

    public static void printAdr(Object o) {
        System.out.println("printing adr: "+ o.hashCode());
    }

    public static void showMethods(Object o, boolean showAll) {
        Method[] methods;
        if (showAll) {
            methods = o.getClass().getMethods();
        }
        else {
            methods = o.getClass().getDeclaredMethods();
        }

        for (Method method : methods) {
            System.out.println(method.getName());
        }
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
