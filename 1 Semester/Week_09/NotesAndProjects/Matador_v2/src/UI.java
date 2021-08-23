import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public void createAccounts() {
        int input = Integer.parseInt(getUserInput("Input amount of players: "));

        for (int i = 0; i < input; i++) {
            Main.accounts.add(new BankAccount(30000));
            assignPlayer(Main.accounts.get(i));
        }
    }


    public static void assignPlayer(BankAccount account){
        String input = getUserInput("Input name of player: ");
        account.setOwner(input);
        System.out.println(account.getOwner());
    }


    public static String getUserInput(String msg){
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    public static void withdrawAmount(BankAccount account) {
        int input=0;

        try {
            input = Integer.parseInt(getUserInput("Withdraw Amount: "));
        }catch (InputMismatchException e){
            System.out.println(e.toString());
            input = Integer.parseInt(getUserInput("Withdraw Amount: "));
        }

        float currentBalance = account.getBalance();
        account.setBalance(currentBalance - input);
    }
}
