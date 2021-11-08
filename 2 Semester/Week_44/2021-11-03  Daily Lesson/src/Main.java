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
        objectList.add(new Hund());
        objectList.add(new Riskoger());
        objectList.add(new Fly());
        objectList.add(new Kaffemaskine());
        objectList.add(new Hund());
        objectList.add(new Riskoger());
        objectList.add(new Fly());
        objectList.add(new Hund());
        objectList.add(new Riskoger());

        for (Command command : objectList) {
            command.execute();
        }

        Bil bil1 = new Bil(new BenzinMotor());
        Bil bil2 = new Bil(new DieselMotor());
        Bil bil3 = new Bil(new ElMotor());
        Bil bil4 = new Bil(new BenzinMotor());
        Bil bil5 = new Bil(new DieselMotor());

        List<Bil> bils = new ArrayList<>();
        bils.add(bil1);
        bils.add(bil2);
        bils.add(bil3);
        bils.add(bil4);
        bils.add(bil5);

        for (Bil bil : bils) {
            bil.motor.kør();
        }
    }
}
