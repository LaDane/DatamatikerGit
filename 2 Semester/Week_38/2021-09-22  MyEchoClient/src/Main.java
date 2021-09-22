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
        String fromServer = "";

        try {
            Socket socket = new Socket("localhost", 8285);
            Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            while(!message.equals("CLOSE")) {
                message = keyboard.nextLine();
                pw.println(message);
                fromServer = sc.nextLine();
                System.out.println(fromServer);
            }
        }
        catch (IOException e) {e.printStackTrace();}
    }
}
