import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Static utility methods
 */
public class Util {

    public static int[] range(int min, int max) {
        int[] arr = new int[Math.abs(max - min)];
        for (int i = min; i < max; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void shuffleArray(int[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void printIntArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static String[] readCsv(String path) {
        // A csv has n commas and n+1 values
        String[] textArr = readFile(path);
        StringBuilder textStr = new StringBuilder();
        for (String s : textArr) {
            textStr.append(s);
        }

        int numValues = occurrencesOf(',', textStr.toString()) + 1;
        String[] csv = new String[numValues];
        csv = textStr.toString().split(",");
        return csv;
    }

    public static int occurrencesOf(char c, String s) {
        int numOccurrences = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                numOccurrences++;
            }
        }
        return numOccurrences;
    }

    public static String[] readFile(String path) {
        String[] contents = new String[1];
        File file = new File(path);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                contents[0] = scanner.nextLine();
            }
            int i = 1;
            while (scanner.hasNextLine()) {
                contents = Arrays.copyOf(contents, i + 1);
                contents[i] = scanner.nextLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't load CSV");
            e.printStackTrace();
        }
        return contents;
    }

    /**
     * Shift subscripts of an array one index to the right.
     */
    public static void shiftArray(Object[] array) {
        Object temp = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = temp;
    }
}
