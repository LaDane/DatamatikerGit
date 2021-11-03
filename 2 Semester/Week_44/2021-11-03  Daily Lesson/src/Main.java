import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Command> objectList = new ArrayList<>();

        objectList.add(new Hund());
        objectList.add(new Riskoger());
        objectList.add(new Hund());
        objectList.add(new Kaffemaskine());
        objectList.add(new Riskoger());
        objectList.add(new Fly());
        objectList.add(new Bil());
        objectList.add(new Hund());
        objectList.add(new Riskoger());
        objectList.add(new Fly());
        objectList.add(new Kaffemaskine());
        objectList.add(new Bil());
        objectList.add(new Hund());
        objectList.add(new Riskoger());
        objectList.add(new Fly());
        objectList.add(new Bil());
        objectList.add(new Hund());
        objectList.add(new Riskoger());

        for (Command command : objectList) {
//            if (o instanceof Hund)
//                ((Hund) o).hyl();
//            if (o instanceof Riskoger)
//                ((Riskoger) o).kogRis();
//            if (o instanceof Kaffemaskine)
//                ((Kaffemaskine) o).bryg();
//            if (o instanceof Bil)
//                ((Bil) o).kør();
            command.execute();
        }
    }
}
