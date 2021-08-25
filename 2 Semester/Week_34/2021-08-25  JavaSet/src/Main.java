import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Peter", "Valborg", "Martin", "Asger", "Rabee", "Christain", "Inga", "Christain", "Valborg"};
        String[] otherNames = {"Peter", "Valborg", "Martin", "Little Jo", "Asger", "Rabee", "Christain", "Inga", "Christain", "Valborg"};
        List<String> stringList = new ArrayList<>(Arrays.asList(names));
        stringList.add("Nikolaj");

        for (String s : stringList) {
            System.out.println(s);
        }

        System.out.println("\n\tHashset\n");
        Set<String> stringSet = new HashSet<>(stringList);
        for (String s : stringSet) {
            System.out.println(s);
        }
        // Hashset sorts list

        System.out.println("\n\tTreeset\n");
        Set<String> stringTreeSet = new TreeSet<>(stringList);
        for (String s : stringTreeSet) {
            System.out.println(s);
        }
        // Treesets removes all doubles

        System.out.println("\n\tLinked Hashset\n");
        Set<String> otherNamesSet = new LinkedHashSet<>(Arrays.asList(otherNames));
        otherNamesSet.removeAll(stringList);
        for (String s : otherNamesSet) {
            System.out.println(s);
        }
        // LinkedHashSet removeAll removes values that are present in both lists
    }
}
