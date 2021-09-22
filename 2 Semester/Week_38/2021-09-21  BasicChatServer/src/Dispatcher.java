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
            Msg nextMessage = echoServer.getMessage();
            boolean privateMsg = false;
            if (!nextMessage.action.equals("all")) {
                privateMsg = true;
            }

            for (ClientHandler cl : echoServer.connectedClients) {
                if (privateMsg && nextMessage.action.equals(cl.clientName.toLowerCase())) {
                    PrintWriter clpw = cl.getPw();
                    clpw.println(nextMessage.data);
                }

                if (!privateMsg) {
                    PrintWriter clpw = cl.getPw();
                    clpw.println(nextMessage.data);
                }
            }
        }
    }
}
