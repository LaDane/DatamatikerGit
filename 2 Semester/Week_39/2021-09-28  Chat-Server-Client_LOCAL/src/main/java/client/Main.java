package client;

import util.Constants;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startClient();
    }

    private void startClient() {
        Scanner keyboard = new Scanner(System.in);
        String clientName = null;

        System.out.println("To connect to the server use 'CONNECT#' followed by a name.");
        while (clientName == null) {
            String input = keyboard.nextLine();
            if (input.contains("CONNECT#")) {
                String[] inputSplit = input.split("#");
                clientName = inputSplit[1];
            }
        }
        System.out.println("Attempting to connect as user '"+ clientName + "'.");

        try {
            Socket socket = new Socket("localhost", Constants.PORT);

            Scanner sc = new Scanner(socket.getInputStream());
            Reader reader = new Reader(sc, socket);
            reader.start();

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Writer writer = new Writer(keyboard, pw, socket, clientName);
            writer.start();
        }
        catch (IOException e) {e.printStackTrace();}
    }
}

class Writer extends Thread {
    Scanner keyboard;
    PrintWriter pw;
    Socket socket;
    String clientName;

    public Writer(Scanner keyboard, PrintWriter pw, Socket socket, String clientName) {
        this.keyboard = keyboard;
        this.pw = pw;
        this.socket = socket;
        this.clientName = clientName;
    }

    @Override
    public void run() {
        try {Thread.sleep(1000);}               // wait for client to connect
        catch (InterruptedException e) {e.printStackTrace();}
        pw.println(clientName);

        String message = "";
        while (true) {
            message = keyboard.nextLine();
            pw.println(message);
        }
    }
}

class Reader extends Thread {
    Scanner scFromServer;
    Socket socket;

    public Reader(Scanner scFromServer, Socket socket) {
        this.scFromServer = scFromServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        String msg = "";
        while (true) {
            msg = scFromServer.nextLine();
            System.out.println(msg);
            if (msg.contains("CLOSE"))
                break;
        }
        try {socket.close();}
        catch (IOException e) {e.printStackTrace();}
        System.out.println("Disconnecting...");
        System.exit(0);
    }
}
