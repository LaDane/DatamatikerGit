import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    private int port;
    private HashMap<String, String> translations = new HashMap<>();
    public BlockingQueue<ClientHandler> connectedClients = new ArrayBlockingQueue<>(10);
    public BlockingQueue<Msg> messages = new ArrayBlockingQueue<>(10);

    public EchoServer(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        System.out.println("Starting server...");
        fillTranslations();

        ExecutorService dispatcherES = Executors.newFixedThreadPool(1);
        Dispatcher dispatcher = new Dispatcher(this);
        dispatcherES.execute(dispatcher);

        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService clientES = Executors.newFixedThreadPool(10);
        while(true) {
            Socket client = serverSocket.accept();
            ClientHandler cl = new ClientHandler(client, translations, this);
            addConnectedClient(cl);

            clientES.execute(cl);
        }
    }

    private void fillTranslations() {
        translations.put("Hund", "Dog");
        translations.put("Bil", "Car");
        translations.put("Fly", "Plane");
        translations.put("Spis", "Eat");
        translations.put("Drik", "Drink");
    }

    private void addConnectedClient(ClientHandler cl) {
        try {connectedClients.put(cl);}
        catch (InterruptedException e) {e.printStackTrace();}
    }

    public void removeConnectedClient(ClientHandler cl) {
        connectedClients.remove(cl);
    }

    public void addMessage(String action, String message) {
        try {messages.put(new Msg(action, message));}
        catch (InterruptedException e) {e.printStackTrace();}
    }

    public Msg getMessage() {
        Msg message = null;
        try {message = messages.take();}
        catch (InterruptedException e) {e.printStackTrace();}
        return message;
    }
}
