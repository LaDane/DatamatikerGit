import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ClientHandler implements Runnable{

    Socket client;
    PrintWriter pw;
    Scanner sc;
    HashMap<String, String> translations;
    EchoServer echoServer;

    public ClientHandler(Socket client, HashMap<String, String> translations, EchoServer echoServer) throws IOException {
        this.client = client;
        // TODO: create cl with shared resource
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
        this.translations = translations;
        this.echoServer = echoServer;
    }

    // TODO: create new constructor with shared messages queue

    @Override
    public void run() {
        protocol();
    }

    public void protocol() {
        pw.println("CLOSE to quit");
        String message = "";
        while (!message.equals("CLOSE")) {
            message = sc.nextLine();

            if (message.contains("#") && !message.contains("CLOSE")) {
                String[] messageSplit = message.split("#");
                String action = messageSplit[0];
                String data = messageSplit[1];

                actionSwitch(action, data);
            }
            else if (message.contains("CLOSE")){
                clientClose();
            }
            else {
                pw.println("Unknown command");
            }
        }
        clientClose();
    }

    private void actionSwitch(String action, String data) {
        switch (action) {
            case "ALL": actionAll(data); break;
            case "UPPER": pw.println(actionUpper(data)); break;
            case "LOWER": pw.println(actionLower(data)); break;
            case "REVERSE": pw.println(actionReverse(data)); break;
            case "TRANSLATE": pw.println(actionTranslate(data)); break;
        }
    }

    private void clientClose() {
        echoServer.removeConnectedClient(this);

        try {client.close();}
        catch (IOException e) {e.printStackTrace();}
    }

    private void actionAll(String data) {
        echoServer.addMessage(data);
    }

    private String actionUpper(String data) {
        return data.toUpperCase();
    }

    private String actionLower(String data) {
        return data.toLowerCase();
    }

    private String actionReverse(String data) {
        StringBuilder sb = new StringBuilder(data);
        return sb.reverse().toString();
    }

    private String actionTranslate(String data) {
        return translations.getOrDefault(data, "NOT_FOUND");
    }

    public PrintWriter getPw() {
        return this.pw;
    }
}
