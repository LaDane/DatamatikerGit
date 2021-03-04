import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static ArrayList<String[]> texts = new ArrayList<String[]>();

    public static void main(String[] args) throws FileNotFoundException{

        // Filling up arraylist texts with data
        File file = new File("data.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            texts.add(scan.nextLine().split(" "));
        }

        // Counting amount of words
        System.out.println("\nPrinting the amount of words in each line of the paragraph: ");
        for (String[] s : texts) {
            System.out.print("\t"+ s.length);
        }
        System.out.println("\n");

        // Displaying words starting with letter
        String searchForLetter = "Ø";
        System.out.println("Printing words starting with the letter '"+ searchForLetter +"': ");
        printWordsStartingWith(searchForLetter);
        System.out.println();

        // Displaying words of the right length
        int desiredLengthOfWord = 3;
        System.out.println("Printing words containing '"+ desiredLengthOfWord + "' letters: ");
        printWordsOfLength(desiredLengthOfWord);
        System.out.println();

        // Displaying words with double consonants
        System.out.println("Printing words with double consonants:");
        printWordsWithDoubleConsonant();
        System.out.println();

        // Display longest sentence
        System.out.println("Printing index of longest sentence: ");
        findLongestSentence();
        System.out.println();

        // Display part of a word using start index and end index
        String wordToPrint = "København";
        int startIndex = 1;
        int endIndex = 4;
        System.out.println("Printing part of word '"+ wordToPrint +"' between index '"+ startIndex +"' and '"+ endIndex +"': ");
        printPartOfWord(wordToPrint, startIndex, endIndex);
        System.out.println();

        // Display text if reversed text matches original text
        String txt = "Den laks skal ned";
        System.out.println("Print a reversed sentence if it matches the original sentence while ignoring capitalization.\n\tOriginal text : "+ txt);
        printIfPalindrome(txt);
    }


    private static void printWordsStartingWith(String pattern) {
        for (int i = 0; i < texts.size(); i++) {
           for (String s: texts.get(i)) {
               if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase())) {
                   System.out.println("\t"+ s);
               }
           }
        }
    }


    private static void printWordsOfLength(int desiredLength) {

        for (int i = 0;  i < texts.size(); i++) {
            for (String s : texts.get(i)) {

                boolean wordIsValid = true;

                if (s.length() == desiredLength) {
                    for (int j = 0; j < s.length(); j++) {
                        char c = s.charAt(j);

                        if (Character.isDigit(c)) {
                            wordIsValid = false;
                        }
                    }
                    if (s.contains(",") || s.contains(".")) {
                        wordIsValid = false;
                    }
                    if (wordIsValid) {
                        System.out.println("\t"+ s);
                    }
                }
            }
        }
    }

    /*
    1.a Lav en ny metode printWordsWithDoubleConsonant()
    1.b Metoden skal gennemløb hver linie og hvert ord i hver linie
    1.c Tjek om den enkelte karakter i hvert ord er identisk med forrige karakter. Hint: Det kan være en god ide FØRST at tjekke bogstavet er en konsonant.
        Det anbefales her at du skriver en separat metode, der alene tager sig af dét. Denne metode skal både sikre at karakteren hverken er en vokal eller et tal (hint: Character.isDigit(c))
    1.d Kald metoden fra main.
     */

    private static void printWordsWithDoubleConsonant() {
        for (int i = 0; i < texts.size(); i++) {
            for (String s : texts.get(i)) {
                if (wordHasDoubleConsonant(s)) {
                    System.out.println("\t"+ s);
                }
            }
        }
    }

    private static boolean wordHasDoubleConsonant(String s) {
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        char[] chars = s.toCharArray();
        char lastConsonant = '¤';

        for (char c : chars) {
            if (consonants.contains(""+c)) {
                if (c == lastConsonant) {
                    return true;
                }
                else {
                    lastConsonant = c;
                }
            }
        }
        return false;
    }


    /*
    2.a Kopier linie 12 til 19 ind i metoden (eller de linier der henter filen ind, scanner og splitter den i et while loop).
    2.b På linien hvor der laves et split array, skal du ændre så du istedet bruger denne kommando til at splitte:   String[] splitarray = scan.nextLine().split("\\. ");
    2.c Hold styr på mens du løber gennem teksten om sætningen er længere end den sætning der pt. er længst.
    2.d Kald metoden fra main
    */

    private static void findLongestSentence() {
        File file = new File("data.txt");
        Scanner scan;

        try {
            scan = new Scanner(file);
        } catch (IOException e) {
            scan = null;
            System.out.println(e.getCause());
        }

        if (scan != null) {

            int index = 0;
            int longestSentenceIndex = 0;
            int longestSentenceAmount = 0;

            while(scan.hasNextLine()) {
                String[] splitArray = scan.nextLine().split("\\. ");
                String indexString = Arrays.toString(splitArray);

                System.out.println("\tCurrent index = "+ index +"\tSentence length = "+ indexString.length());

                if (indexString.length() > longestSentenceAmount) {
                    longestSentenceAmount = indexString.length();
                    longestSentenceIndex = index;
                }
                index++;
            }

            System.out.println("\t= Longest sentence index : "+ longestSentenceIndex);
        }
    }


    /*
    3.a Lav en metode, printPartOfWord(), med tre parametre: 1. parameter er ordet, 2. parameter er index for det bogstav delmængden starter med og 3.  parameter er længden på delmængden
        Ex: argumenterne "Købehavn", 1 og 4  skal give outputtet "øben".
    3.b Sørg for at metoden kan håndtere at blive kaldt med tal-argumenter som er for høje. Brug en try catch hvor du håndterer undtagelsen StringIndexOutOfBounds.
    3.c: I catch blokken skal du tjekke om argument 2 er lavere end ordets længe. Hvis det er tilfældet, skal delmængden starte ved argument 2 og til og med sidste bogstav.
        Hvis argument 2 er højere end ordets længde skal du give en passende fejlmeddelelse
        Ex:  Købehavn, 6, 4  skal . give outputtet 'avn'
    */

    public static void printPartOfWord(String word, int startIndex, int endIndex) {
        char[] chars = word.toCharArray();
        String printStr = "";

        for (int i = 0; i < chars.length; i++) {
            if (i >= startIndex && i <= endIndex) {
                printStr+=chars[i];
            }
        }
        System.out.println("\t"+ printStr);
    }


    /*
    4.a Skriv en metode printIfPalindrome() som tager en tekststreng som argument og printer den HVIS den kan skrives bagfra uden at ændre sig.
        (Hint: Lad dig inspirere i dokumentationen for String klassen)
    4.b Sørg for at metoden ikke er case-sensitiv.
    4.c Kald metoden fra main med argumentet "Den laks skal ned", for at teste den.
    */

    public static void printIfPalindrome(String txt) {
        char[] chars = txt.toCharArray();
        String reversedTxt = "";

        for (int i = chars.length-1; i >= 0; i--) {
            reversedTxt+=chars[i];
        }

        if (txt.toLowerCase().equals(reversedTxt.toLowerCase())) {
            System.out.println("\tReversed text : "+ reversedTxt +"\n\t= Reversed text matches original text!");
        } else {
            System.out.println("\tReversed text does NOT match original text");
        }
    }
}
