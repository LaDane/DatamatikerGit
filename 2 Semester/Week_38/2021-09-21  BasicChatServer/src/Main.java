import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        EchoServer echoServer = new EchoServer(8285);

        try {echoServer.startServer();}
        catch (IOException e) {e.printStackTrace();}
    }
}
