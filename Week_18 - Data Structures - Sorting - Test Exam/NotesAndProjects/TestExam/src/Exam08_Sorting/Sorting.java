package Exam08_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void sorting() {
        String[] strArray = new String[5];
        for (int i = 0; i < strArray.length; i++) {
            String strMsg = "Input a word on spot "+ (i + 1) +"\n";
            String strInput = getUserInput(strMsg);
            strArray[i] = strInput;
        }
        Arrays.sort(strArray);

        for (int i = strArray.length -1; i >= 0; i--) {
            System.out.println(strArray[i]);
        }
    }

    public static String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
