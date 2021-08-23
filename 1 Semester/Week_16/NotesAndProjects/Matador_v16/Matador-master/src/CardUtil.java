import java.io.File;
import java.io.FileNotFoundException;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Static utility methods
 */
public class CardUtil {

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
