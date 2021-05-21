import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class WordGame {

    public static ArrayList<String> repeatWord(ArrayList<String> input, int k) {

        if(input == null){
            throw new NullPointerException();
        }
        if(k<2){
            throw new IllegalArgumentException();
        }

        // For every word that comes in input array, add that word to another array, amount of times = k
        // Nested for loop

        ArrayList<String> outputArray = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {

            // for loop -> add string k amount of times

            for (int j = 0; j < k; j++) {
                outputArray.add(input.get(i));
            }
        }

        sortStringArrayByLength(outputArray.toArray(new String[0]));

        return outputArray;
    }

    private static void sortStringArrayByLength(String[] stringArray) {
        System.out.println("-- sorting array of string --");
        Arrays.sort(stringArray, Comparator.comparing(String::length));
        Arrays.stream(stringArray).forEach(System.out::println);
    }
}
