package client;

import util.Constants;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public void run() throws IOException {

        InetAddress ip = InetAddress.getByName("localhost");
        Socket socket = new Socket(ip, Constants.PORT);

        Scanner keyboard = new Scanner(System.in);

        Scanner scanner = new Scanner(socket.getInputStream());
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

        Thread sendMessage = new Thread(() -> {
            while (keyboard.hasNextLine()) {
                String msg = keyboard.nextLine();
                pw.println(msg);
            }
        });

        Thread receiveMessage = new Thread(() -> {
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                System.out.println(msg);
            }
        });

        sendMessage.start();
        receiveMessage.start();
    }
}
