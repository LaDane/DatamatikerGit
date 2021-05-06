package Exam05_Menu;

import java.util.Scanner;

public class MenuChoice {
    public static int menuChoise() {
        int menuChosen;

        while(true) {
            String menu = "\n1.\t\tCalculate\n2.\t\tPrint\n3.\t\tHelp\n";
            String menuInput = getUserInput(menu);
            try {
                menuChosen = Integer.parseInt(menuInput);
                if (menuChosen >= 1 && menuChosen <= 3)
                    break;
                else
                    System.out.println("Input is not know to the system! Try Again!");
            } catch (Exception e) {
                System.out.println("Input cannot be converted to integer! Try Again!");
            }
        }
        return menuChosen;
    }

    public static String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
