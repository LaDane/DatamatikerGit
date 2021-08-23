import java.util.Scanner;

public class Main {

    private static BankAccount account1;
    private static BankAccount account2;
    private static BankAccount account3;


    public static void main(String[] args) {
        account1 = new BankAccount(30000.00f);
        account2 = new BankAccount(30000.00f);
        account3 = new BankAccount(30000.00f);

        assignPlayer(account1);
//        assignPlayer(account2);
//        assignPlayer(account3);

        printAccounts();

//        account1.withdrawAmount(4000.00f);

        withdraw(account1);

        printAccounts();
    }


    public static void withdraw(BankAccount account) {
        System.out.println("Input an integer to withdraw from account");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        try{
            account.withdrawAmount(Float.parseFloat(input));
        } catch (Exception e) {
            System.out.println("Input must be a number!");
        }
    }


    public static void printAccounts() {
        System.out.println("\n"+ account1);
    }


    public static void assignPlayer(BankAccount account) {
        System.out.println("Skriv konto ejers navn: ");
        Scanner scan = new Scanner(System.in);                  // get user input
        String input = scan.nextLine();

        account.setOwner(input);
        System.out.println(account.saldo);
        System.out.println(account.getOwner());

    }
}
