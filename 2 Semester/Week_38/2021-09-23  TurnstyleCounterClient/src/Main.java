import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int previousTotal = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.startClient();
    }

    private void startClient() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Choose client type\t1 = Turnstyle\t2 = Monitor");
        String input = keyboard.nextLine();
        int clientType = parseStringInt(input);
        boolean isTurnstyle = false;
        if (clientType == 1)
            isTurnstyle = true;

        try {
            Socket socket = new Socket("localhost", 8285);

            Scanner sc = new Scanner(socket.getInputStream());
            Reader reader = new Reader(sc, isTurnstyle);
            reader.start();

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Writer writer = new Writer(keyboard, pw, isTurnstyle);
            writer.start();
        }
        catch (IOException e) {e.printStackTrace();}
    }

    public static int parseStringInt(String value) {
        int valueInt = -1;
        try {valueInt = Integer.parseInt(value);}
        catch (NumberFormatException e) {return -1;}
        return valueInt;
    }

//    public static int getPreviousTotal() {
//        return previousTotal;
//    }
//
//    public static void setPreviousTotal(int total) {
//        previousTotal = total;
//    }
}

class Writer extends Thread {
    boolean keepRunning = true;
    Scanner keyboard;
    PrintWriter pw;
    boolean isTurnstyle;

    public Writer(Scanner keyboard, PrintWriter pw, boolean isTurnstyle) {
        this.keyboard = keyboard;
        this.pw = pw;
        this.isTurnstyle = isTurnstyle;
    }

    @Override
    public void run() {
        String message = "";

        if (isTurnstyle)
            message = "1";
        else
            message = "2";
        pw.println(message);


        while (keepRunning) {
//            message = keyboard.nextLine();
            Random r = new Random();
            int sleepTime = r.nextInt((1500 - 10) + 1) + 10;

            if (isTurnstyle) {
                message = "+";
            }
            else {
                message = "=";
                sleepTime = 10;
            }
            pw.println(message);

            try {Thread.sleep(sleepTime);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}

class Reader extends Thread {
    boolean keepRunning = true;
    Scanner scFromServer;
    boolean isTurnstyle;
    int oldSpectators = 0;

    public Reader(Scanner scFromServer, boolean isTurnstyle) {
        this.scFromServer = scFromServer;
        this.isTurnstyle = isTurnstyle;
    }

    @Override
    public void run() {
        while (keepRunning && scFromServer.hasNextLine()) {

            if (isTurnstyle) {
                System.out.println("READER: " + scFromServer.nextLine());
            }
            else {
                int newSpectators = Main.parseStringInt(scFromServer.nextLine());
                if (oldSpectators != newSpectators) {
                    System.out.println("READER: Total Spectators : "+ newSpectators);
                    oldSpectators = newSpectators;
                }
            }
        }
    }
}
