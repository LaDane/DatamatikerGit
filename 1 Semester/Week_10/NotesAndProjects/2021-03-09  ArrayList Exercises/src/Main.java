import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> stringArray = new ArrayList<String>();

        stringArray.add("Jeser");
        stringArray.add("is");
        stringArray.add("awesome");
        System.out.println(stringArray.toString());

        stringArray.add(2,"not");
        System.out.println(stringArray.toString());

        stringArray.add(2,"totally");
        System.out.println(stringArray.toString());

        for (int i = 0; i < stringArray.size(); i++) {
            if (stringArray.get(i).equals("totally")) {
                stringArray.remove(i);
            }
        }
        System.out.println(stringArray.toString());

        //for (String string : stringArray) {
        //}
        Collections.sort(stringArray.subList(1, stringArray.size()));
        System.out.println(stringArray.toString());
    }
}
