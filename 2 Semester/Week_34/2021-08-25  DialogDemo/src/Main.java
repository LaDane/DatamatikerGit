import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dialog dialog = new Dansk();
        System.out.println(dialog.welcome());

        while(true) {
            dialog = changeLanguage(dialog, getInput("\nSelect language - da/eng"));
            System.out.println(dialog.welcome());
            if (getInput(dialog.quit()).equals("q")) {
                break;
            }
        }
    }

    public static Dialog changeLanguage(Dialog dialog, String suggestedLanguage) {
//        if (suggestedLanguage.equals("da")) {
//            return new Dansk();
//        }
//        else if (suggestedLanguage.equals("eng")) {
//            return new English();
//        }
//        else {
//            return dialog;
//        }
        switch (suggestedLanguage) {
            case "da":
                return new Dansk();
            case "eng":
                return new English();
            default:
                return dialog;
        }
    }

    public static String getInput(String s) {
        System.out.println("\n"+ s);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
