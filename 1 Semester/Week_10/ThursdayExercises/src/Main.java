import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Exercise 1
        int _1 = 3, _2 = -2, _3 = 7;
        System.out.println(min(_1, _2, _3));

        // Exercise 2
        printEvenNumbers(12);
        System.out.println();

        // Exercise 3
        System.out.println(smallestAbsVal(1, 9, -11));

        // Exercise 4
        System.out.println(sumDigits(-99));

        // Exercise 5
        reverseVertical("laptop");

        // Exercise 6
//        System.out.println();
//        try { processName(); }
//        catch (Exception e) {}

        // Exercise 7
        repeat("Hej");

        // Exercise 8
//        shortestName(3);

        // Exercise 9
        randomNumbers();
    }

    // Exercise 1
    public static int min(int _1, int _2, int _3) {
        int firstCompare = Math.min(_1, _2);
        int secondCompare = Math.min(_2, _3);

        return Math.min(firstCompare, secondCompare);
    }

    // Exercise 2
    public static void printEvenNumbers(int max) {
        for (int i = 2; i <= max; i+=2){
            System.out.print(i+" ");
        }
    }

    // Exercise 3
    public static int smallestAbsVal(int _1, int _2, int _3) {
        return min(Math.abs(_1), Math.abs(_2), Math.abs(_3));
    }

    // Exercise 4
    public static int sumDigits(int number) {
        char[] chars = ("" + number).toCharArray();
        int sumTotal = 0;
        for (char c: chars) {
            try {
                sumTotal += Integer.parseInt(String.valueOf(c));
            } catch (Exception e) {}
        }
        return sumTotal;
    }

    // Exercise 5
    public static void reverseVertical(String s) {
        char[] chars = s.toCharArray();
        String reversedS = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            //reversedS += chars[i];
            System.out.print(chars[i] +" ");
        }
    }

    // Exercise 6
    public static void processName() {
        System.out.print("Skriv venligst dit fulde navn: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String inputUpper = input.toUpperCase();
        System.out.println("Navnet med store bokstaver: "+ inputUpper);
    }

    // Exercise 7
    public static void repeat(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            output += s;
        }
        System.out.println(output);
    }

    // Exercise 8
    public static void shortestName(int n) {
        String[] names = new String[n];
        for (int i = 1; i <= n; i++) {
            System.out.print("Navn #"+ i +"? ");
            Scanner scanner = new Scanner(System.in);
            names[i-1] = scanner.nextLine();
        }

        String shortestName = names[0];
        for (String name : names) {
            if (name.length() < shortestName.length()) {
                shortestName = name;
            }
        }

        System.out.println(shortestName);
    }

    // Exercise 9
    public static void randomNumbers() {
        boolean underMax = true;
        int iteration = 0;
        Random random = new Random();

        while(underMax) {
            int randomInt = random.nextInt(1000);
            if (iteration == 0 && randomInt > 900) {
                continue;
            }
            else if (iteration > 0 && randomInt > 900) {
                System.out.println(randomInt);
                return;
            }
            else {
                System.out.println(randomInt);
            }
            iteration++;
        }
    }
}
