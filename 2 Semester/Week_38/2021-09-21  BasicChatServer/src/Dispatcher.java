import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class Dispatcher implements Runnable{

    EchoServer echoServer;

    public Dispatcher(EchoServer echoServer) {
        this.echoServer = echoServer;
    }

    @Override
    public void run() {
        String outMessage = "";
        while (true) {
            String nextMessage = echoServer.getMessage();
            for (ClientHandler cl : echoServer.connectedClients) {
                PrintWriter clpw = cl.getPw();
                clpw.println(nextMessage);
            }
        }
    }
}
