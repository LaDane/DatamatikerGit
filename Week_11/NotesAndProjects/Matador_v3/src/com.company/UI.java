
package com.company;
import java.util.Scanner;

public class UI {
    public int maxPlayers = 6;
    private int startBalance = 3000;

    public void createAccounts(){
        String input = "";
        System.out.println("Tast Q for at quitte");

        while(!input.toUpperCase().equals("q") && Main.players.size() < maxPlayers){
            input = getUserInput("Skriv navn på spiller nr. " + (Main.players.size() -1) + ": ");
            Player player = new Player();
        }

        System.out.println("Tak, spillets deltagere er registreret");
    }

    public static String getUserInput(String msg){
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }
}
