import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket client = serverSocket.accept();
        ClientHandler cl = new ClientHandler(client);
        cl.protocol();
    }
}
