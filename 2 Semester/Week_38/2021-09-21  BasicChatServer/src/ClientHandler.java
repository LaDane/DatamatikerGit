import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    String clientName;
    Socket client;
    PrintWriter pw;
    Scanner sc;
    HashMap<String, String> translations;
    EchoServer echoServer;

    public ClientHandler(Socket client, HashMap<String, String> translations, EchoServer echoServer) throws IOException {
        this.client = client;
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
        this.translations = translations;
        this.echoServer = echoServer;
    }

    @Override
    public void run() {
        protocol();
    }

    public void protocol() {
        pw.println("CLOSE to quit\nEnter name");
        this.clientName = sc.nextLine();

        // TODO: add functionality to send messages to 1 specific other client by clientName

        String message = "";
        while (!message.equals("CLOSE")) {
            message = sc.nextLine();

            if (message.contains("#") && !message.contains("CLOSE")) {
                String[] messageSplit = message.split("#");
                String action = messageSplit[0];
                String data = messageSplit[1];

                boolean sendMsgToUser = false;
                for (ClientHandler cl : echoServer.connectedClients) {
                    if (action.toLowerCase().equals(cl.clientName.toLowerCase())) {
                        sendMsgToUser = true;
                        break;
                    }
                }
                if (sendMsgToUser) {
                    actionMsg(action, data);
                    continue;
                }
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
            case "ALL": actionMsg(action, data); break;
            case "UPPER": pw.println(actionUpper(data)); break;
            case "LOWER": pw.println(actionLower(data)); break;
            case "REVERSE": pw.println(actionReverse(data)); break;
            case "TRANSLATE": pw.println(actionTranslate(data)); break;
        }
    }

    private void actionMsg(String action, String data) {
        echoServer.addMessage(action.toLowerCase(), data);
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

    private void clientClose() {
        echoServer.removeConnectedClient(this);

        try {client.close();}
        catch (IOException e) {e.printStackTrace();}
    }
}
