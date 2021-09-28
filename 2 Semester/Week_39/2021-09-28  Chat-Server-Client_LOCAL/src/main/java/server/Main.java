package server;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {

    //Call server with arguments like this: 8088
    public static void main(String[] args) {
        int port = 8088;
        
        try {
            if (args.length == 1) {
                port = Integer.parseInt(args[0]);

                ChatServer server = new ChatServer(port);
                server.connect();
            }
            else {
                throw new IllegalArgumentException("Server not provided with the right arguments");
            }
        } catch (NumberFormatException ne) {
            System.out.println("Illegal inputs provided when starting the server!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
