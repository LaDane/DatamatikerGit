package server;

import util.Constants;
import util.Helpers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

class ClientHandler implements Runnable {

    private static int CLOSE_NORMAL = 0;
    private static int CLOSE_ILLEGAL_INPUT = 1;
    private static int CLOSE_USER_NOT_FOUND = 2;

    private String name;
    private Scanner scanner;
    private PrintWriter pw;
    private Socket socket;
    private CopyOnWriteArrayList<ClientHandler> clientHandlers;

    public ClientHandler(Socket socket, CopyOnWriteArrayList<ClientHandler> clientHandlers) throws IOException {
        this.socket = socket;
        this.scanner = new Scanner(socket.getInputStream());
        this.pw = new PrintWriter(socket.getOutputStream(), true);
        this.clientHandlers = clientHandlers;
    }

    @Override
    public void run() {
        protocol();
    }

    private void protocol() {
        this.name = scanner.nextLine();
        System.out.println("User '"+ this.name + "' has connected.");
        pw.println("Connected as user '"+ this.name +"'.");
        sendOnlineMsg();

        String msg = "";
        try {
            while (true) {
                msg = scanner.nextLine();

                if (msg.contains("CLOSE")) {                    // Close command -> close connection = normal close
                    clientClose(CLOSE_NORMAL);
                    return;
                }

                int hashtagCount = countOccurrences(msg, '#');
                if (hashtagCount == 2) {                        // Check if message has 2 '#'s
                    String[] msgSplit = msg.split("#");
                    String recipients = msgSplit[1];
                    String data = msgSplit[2];

                    if (msg.contains("*")) {                    // Send to all command
                        actionSendToAll(data);
                        continue;
                    }

                    if (msg.contains("SEND#")) {                // Send private message to recipients
                        actionSendPrivate(recipients, data);
                        continue;
                    }
                    clientClose(CLOSE_ILLEGAL_INPUT);
                    return;
                }
                else {
                    clientClose(CLOSE_ILLEGAL_INPUT);
                    return;
                }
            }
        }
        catch (Exception ignored) {}
    }

    private void clientClose(int closeType) {       //      0 for a normal close | 1 illegal input was received | 2 User not found
        System.out.println("User '"+ this.name +"' has disconnected due to : "+ Constants.CLOSE_TYPES[closeType]);
        clientHandlers.remove(this);
        pw.println("CLOSE = " + Constants.CLOSE_TYPES[closeType]);
        sendOnlineMsg();
        cleanup();
    }

    private void cleanup() {
        this.scanner.close();
        this.pw.close();
        try {this.socket.close();}
        catch (IOException e) {e.printStackTrace();}
    }

    private void sendOnlineMsg() {
        String onlineMessage = getOnlineMessage();
        for (ClientHandler cl : clientHandlers) {
            cl.pw.println(onlineMessage);
        }
    }

    private String getOnlineMessage() {
        String onlineMsg = "ONLINE#";
        for (ClientHandler cl : clientHandlers) {
            onlineMsg += cl.name + ",";
        }
        onlineMsg = onlineMsg.substring(0, onlineMsg.length() - 1);
        return onlineMsg;
    }

    private void actionSendToAll(String data) {
        for (ClientHandler cl : clientHandlers) {
            if (cl == this)
                continue;
            cl.pw.println(data);
        }
    }

    private void actionSendPrivate(String recipients, String data) {
        String[] editedRecipients = Helpers.recipientsToList(recipients);
        boolean nameFound = false;
        for (String recipient : editedRecipients) {
            for (ClientHandler cl : clientHandlers) {
                if (cl.name.equals(recipient)) {
                    nameFound = true;
                    cl.pw.println(data);
                }
            }
        }
        if (!nameFound) {
            clientClose(CLOSE_USER_NOT_FOUND);
        }
    }

    private int countOccurrences(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }
        return count;
    }
}