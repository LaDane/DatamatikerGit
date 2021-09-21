import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static final int DEFAULT_PORT = 2345;
    private ServerSocket serverSocket;

    private void handleClient(Socket socket) throws IOException {
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(socket.getInputStream());

        // Send message to client right after connection
        pw.println("Welcome. Send me a message, please (stop: 'stop'): ");
        String message = scanner.nextLine();
        while(!message.equals("stop")) {
            pw.println(message.toUpperCase());
            message = scanner.nextLine();
        }
        pw.println("Connection closing.");
        socket.close();
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started, listening on " + port);

        while(true) {
            System.out.println("Waiting for a client...");
            Socket socket = serverSocket.accept();                          // Blocking call
            System.out.println("New client connected.");
            handleClient(socket);
        }
    }

    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length == 1) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.printf("Invalid port number, using default (%d)\n", DEFAULT_PORT);
            }
        }

        try {
            new EchoServer().start(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
