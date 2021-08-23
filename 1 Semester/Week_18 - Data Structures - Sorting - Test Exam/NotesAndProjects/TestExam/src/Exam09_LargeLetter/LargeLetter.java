package Exam09_LargeLetter;

import java.util.Scanner;

public class LargeLetter {
    public static void largeLetter() {
        String strMsg = "Write some sentences and then press ENTER to continue\n";
        String strInput = getUserInput(strMsg);

        String[] strArray = strInput.split("\\. ");
        int counter = 0;
        for (String str : strArray) {
            System.out.println(str);
            char[] charArray = str.toCharArray();
            if (Character.isUpperCase(charArray[0]))
                counter++;
        }
        System.out.println(counter +" text strings started with a capitalized letter.");
    }

    public static String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
