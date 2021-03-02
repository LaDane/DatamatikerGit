import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static BankAccount[] accounts = new BankAccount[3];

    public static void main(String[] args) {
        /* accounts[0] = new BankAccount(30000);
        accounts[1] = new BankAccount(30000);
        accounts[2] = new BankAccount(30000);
        assignPlayer(accounts[0]);
        assignPlayer(accounts[1]);
        assignPlayer(accounts[2]); */

        try {
            readAccountData();
        } catch (IOException e) {
            System.out.println("This file does not exist");
        }

        printAccounts();

        accounts[0].withDrawAmount();
        accounts[2].withDrawAmount();

        // printAccounts();
        saveGameData();

    }


    private static void readAccountData() throws IOException {
        File file = new File("data.txt");
        Scanner scan = new Scanner(file);
        String[] accountLine;

        int i = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            accountLine = line.split(":");

            accounts[i] = new BankAccount(Float.parseFloat(accountLine[1]));
            accounts[i].setOwner((accountLine[0]));
            i++;
        }
    }


    public static void printAccounts() {
//      for (int i = 0; i < accounts.length; i++) {
//          System.out.println("\n"+accounts[i]);
//      }

//      for each loop below

        for (BankAccount a: accounts ) {
            System.out.println("\n" + a);
        }
    }


    public static void saveGameData() {
        String gameData = "";

        for (BankAccount a : accounts) {
            gameData += a.getOwner() +" : "+ a.getSaldo() +"\n";
        }

        // save some data to a txt fil
        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.write(gameData);
            writer.close();
        }
        catch(IOException e) {
            System.out.println(e.getCause());
        }
    }


    public static void assignPlayer(BankAccount account){
        String input = getUserInput("Skriv kontoejers navn: ");
        account.setOwner(input);
        System.out.println(account.getOwner());
    }


    public static String getUserInput(String msg){
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }
}

