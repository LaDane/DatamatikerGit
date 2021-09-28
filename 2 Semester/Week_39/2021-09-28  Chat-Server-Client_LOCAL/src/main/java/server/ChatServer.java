package server;

import util.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {

    private CopyOnWriteArrayList<ClientHandler> clientHandlers;
//    private final int port;

    public ChatServer(int port) {
        this.clientHandlers = new CopyOnWriteArrayList<>();
//        this.port = port;
    }

    public void connect() throws IOException {
        ServerSocket serverSocket = new ServerSocket(Constants.PORT);
        System.out.println("Server started...");
        while (true) {
            Socket clientSocket = serverSocket.accept();

            ClientHandler clientHandler = new ClientHandler(clientSocket, this.clientHandlers);
            clientHandlers.add(clientHandler);

            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}
