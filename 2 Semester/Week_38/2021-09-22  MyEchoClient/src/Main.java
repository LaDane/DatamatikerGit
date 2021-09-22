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
        String message = "";

        try {
            Socket socket = new Socket("localhost", 8285);

            Scanner sc = new Scanner(socket.getInputStream());
            Reader reader = new Reader(sc);
            reader.start();

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Writer writer = new Writer(keyboard, pw);
            writer.start();
        }
        catch (IOException e) {e.printStackTrace();}
    }
}

class Writer extends Thread {
    boolean keepRunning = true;
    Scanner keyboard;
    PrintWriter pw;

    public Writer(Scanner keyboard, PrintWriter pw) {
        this.keyboard = keyboard;
        this.pw = pw;
    }

    @Override
    public void run() {
        String message = "";
        while (keepRunning) {
            message = keyboard.nextLine();
            pw.println(message);
        }
//        pw.println("CLOSE");
//        socket.close();
    }
}

class Reader extends Thread {
    boolean keepRunning = true;
    Scanner scFromServer;

    public Reader(Scanner scFromServer) {
        this.scFromServer = scFromServer;
    }

    @Override
    public void run() {
        while (keepRunning && scFromServer.hasNextLine()) {
//            if (scFromServer.nextLine())
                System.out.println("READER: " + scFromServer.nextLine());
        }
    }
}

