package Scanner;

import java.util.Scanner;

public class ScannerExample {
    public static String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
