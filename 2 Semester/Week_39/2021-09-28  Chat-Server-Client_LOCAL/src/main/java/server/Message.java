package server;

import java.util.ArrayList;

public class Message {

    String action;
    String data;
    ArrayList<String> recipientNames;

    public Message(String action, String data) {
        this.action = action;
        this.data = data;
        this.recipientNames = new ArrayList<>();
    }

    public Message(String action, String data, ArrayList<String> recipientNames) {
        this.action = action;
        this.data = data;
        this.recipientNames = recipientNames;
    }

    public String getAction() {
        return action;
    }

    public String getData() {
        return data;
    }

    public ArrayList<String> getRecipientNames() {
        return recipientNames;
    }
}
