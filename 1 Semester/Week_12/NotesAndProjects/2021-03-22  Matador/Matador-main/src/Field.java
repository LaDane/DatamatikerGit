import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Field {
    int id;
    String label;

    public Field(int id, String label) {
        this.id = id;
        this.label = label;
        System.out.printf("\n%d: %s", this.id, this.label);
    }

}
