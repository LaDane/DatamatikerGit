import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public static void main(String[] args) {

        try {
            readAccountData();
        } catch (IOException e) {
            System.out.println("This file does not exist");

            UI ui = new UI();
            ui.createAccounts();
        }

        printAccounts();

        // accounts[0].withDrawAmount();
        // accounts[2].withDrawAmount();

        // printAccounts();
        saveGameData();
    }


    public static void withdrawFromAccount(BankAccount account) {
        UI.withdrawAmount(account);
    }


    private static void readAccountData() throws IOException {
        File file = new File("data.txt");
        Scanner scan = new Scanner(file);
        String[] accountLine;

        int count = 0;

        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            accountLine = line.split(":");

            accounts.add(new BankAccount(Float.parseFloat(accountLine[1])));
            int index = accounts.size();
            accounts.get(index-1).setOwner(accountLine[0]);

            count++;
        }
    }


    public static void printAccounts() {
        for (BankAccount a: accounts ) {        // for each loop
            System.out.println("\n" + a);
        }
    }


    public static void saveGameData() {
        String gameData = "";

        for (BankAccount a : accounts) {
            gameData += a.getOwner() +" : "+ a.getBalance() +"\n";
        }

        try {                                   // save some data to a txt fil
            FileWriter writer = new FileWriter("data.txt");
            writer.write(gameData);
            writer.close();
        }
        catch(IOException e) {
            System.out.println(e.getCause());
        }
    }
}

