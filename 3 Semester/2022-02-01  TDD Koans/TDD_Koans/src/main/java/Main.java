import java.util.ArrayList;
import java.util.Arrays;

class Main {

    static String greet(String s) {
        if (s == null) { return "Hello, my friend."; }
        if (s.toUpperCase().equals(s)) { return "HELLO "+ s +"!"; }
        return "Hello, "+ s +".";
    }

    static String greet(String[] nameArray) {
        String s = "Hello, ";
        ArrayList<String> names = new ArrayList<>(Arrays.asList(nameArray));
        ArrayList<String> upNames = new ArrayList<>();
        ArrayList<String> namesCopy = new ArrayList<>(names);

        // Seperate elements with comma
        for (int i = 0; i < namesCopy.size(); i++) {
            if (namesCopy.get(i).contains(",") && !namesCopy.get(i).contains("\"")) {
                names.remove(i);
                String[] splitArray = namesCopy.get(i).split(",");

                for (int j = 0; j < splitArray.length; j++) {
                    System.out.println("splitArray element " + j + ": " + splitArray[j]);
                    splitArray[j] = splitArray[j].replaceAll(" ", "");
                    names.add(splitArray[j]);
                }
            }
        }
        
        // Move shouted names to upNames
        namesCopy = new ArrayList<>(names);
        for (int i = 0; i < namesCopy.size(); i++) {
            if (namesCopy.get(i).toUpperCase().equals(namesCopy.get(i))) {
                upNames.add(names.get(i));
                names.remove(i);
            }
        }
        
        // Add normal names
        for (int i = 0; i < names.size(); i++) {
            names.set(i, names.get(i).replaceAll("\"", ""));

            if (i == names.size() - 1) {
                if (names.size() == 2) {
                    s = s.substring(0, s.length() - 2);
                    s = s + " ";
                }
                s = s + "and " + names.get(i) + ".";
                break;
            }
            s = s + names.get(i) + ", ";
        }
        
        // Add shouted name at end
        for (int i = 0; i < upNames.size(); i++) {
            s = s + " AND HELLO " + upNames.get(i) + "!";
        }
        return s;
    }
}
