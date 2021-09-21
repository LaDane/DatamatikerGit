import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    Socket socket;
    PrintWriter pw;
    Scanner scanner;

    public void connect(String address, int port) throws IOException {
        socket = new Socket(address, port);
        pw = new PrintWriter(socket.getOutputStream(), true);
        scanner = new Scanner(socket.getInputStream());
        System.out.println(scanner.nextLine());

        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        while (running) {
            String msgToSend = keyboard.nextLine();
            pw.println(msgToSend);
            System.out.println(scanner.nextLine());
            if (msgToSend.equals("stop")) {
                running = false;
            }
        }
        socket.close();
    }

    public static void main(String[] args) {

        try {
            new EchoClient().connect("localhost", 2345);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
