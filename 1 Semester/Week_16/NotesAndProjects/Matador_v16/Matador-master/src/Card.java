import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Card {

    private String text;

    public Card(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }
}
