import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    Socket client;
    EchoServer echoServer;
    PrintWriter pw;
    Scanner sc;
    boolean isTurnstyle = false;
    boolean isMonitor = false;

    public ClientHandler(Socket client, EchoServer echoServer) throws IOException {
        this.client = client;
        this.echoServer = echoServer;
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
    }

    @Override
    public void run() {
        boolean typeSet = false;
        String msg = "";
        pw.println("Set client type.\t1 = Turnstyle\t2 = Monitor");

        while (!msg.equals("CLOSE")) {
            if (!typeSet && sc.hasNextLine()) {
                actionSwitch(sc.nextLine());
                if (isTurnstyle || isMonitor)
                    typeSet = true;
            }

            if (!sc.hasNextLine())
                continue;

            msg = sc.nextLine();
            if (msg.contains("CLOSE"))
                clientClose();

            if (echoServer.allowedToStart())
                actionSwitch(msg);
        }
        clientClose();
    }

    private void actionSwitch(String action) {
        switch (action) {
            case "1": pw.println("Client type set to : "+ actionSetClientType("1")); break;
            case "2": pw.println("Client type set to : "+ actionSetClientType("2")); break;
            case "+": pw.println("Added spectator. Total : "+ actionIncreaseSpectator()); break;
            case "=": pw.println("Total spectators : "+ actionGetTotalSpectators()); break;
            default: pw.println("Invalid command"); break;
        }
    }

    private void clientClose() {
        echoServer.removeClient(this);

        try {client.close();}
        catch (IOException e) {e.printStackTrace();}
    }

    private int actionIncreaseSpectator() {
        return echoServer.addSpectator(1);
    }

    private int actionGetTotalSpectators() {
        return echoServer.getTotalSpectators();
    }

    private String actionSetClientType(String data) {
        String returnString = "";
        if (data.equals("1")) {
            returnString = "Turnstyle";
            isTurnstyle = true;
            isMonitor = false;
        }
        if (data.equals("2")) {
            returnString = "Monitor";
            isTurnstyle = false;
            isMonitor = true;
        }
        return returnString;
    }
}
