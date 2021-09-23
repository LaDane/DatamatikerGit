import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    private int port;
    private int expectedTurnstyles;
    private TurnstyleManager turnstyleManager;

    public EchoServer(int port, int expectedTurnstyles) {
        this.port = port;
        this.expectedTurnstyles = expectedTurnstyles;
        startTurnstyleManager();
    }

    private void startTurnstyleManager() {
        ExecutorService turnstyleManagerES = Executors.newFixedThreadPool(1);
        turnstyleManager = new TurnstyleManager(expectedTurnstyles);
        turnstyleManagerES.execute(turnstyleManager);
    }

    public void startServer() throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService clientHandlerES = Executors.newFixedThreadPool(10);
        while(true) {
            Socket client = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(client, this);
            turnstyleManager.addConnectedClient(clientHandler);
            clientHandlerES.execute(clientHandler);
        }
    }

    public int addSpectator(int amount) {
        int total = turnstyleManager.addSpectator(amount);
        return total;
    }

    public void removeClient(ClientHandler clientHandler) {
        turnstyleManager.removeConnectedClient(clientHandler);
    }

    public boolean allowedToStart() {
        return turnstyleManager.reachedExpectedTurnstyles();
    }

    public int getTotalSpectators() {
        return turnstyleManager.getNumberOfSpectators();
    }
}
