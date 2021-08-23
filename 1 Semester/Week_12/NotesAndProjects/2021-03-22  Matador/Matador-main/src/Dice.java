import java.util.Random;

public class Dice {
    private int d1;
    private int d2;
    private int throwCount = 0;

    public int throwDice() {
        Random r = new Random();
        d1 = r.nextInt(6 - 1) + 1;
        d2 = r.nextInt(6 - 1) + 1;
        // d1 = 1;
        // d2 = 1;
        System.out.println(d1 + d2);
        return d1 + d2;
    }

    public void doubleTHrow() {
        if (d1 == d2) {
            System.out.println("Throw again!");
            throwCount += 1;
            throwDice();
            if (throwCount == 2) {
                goToPrisonForSpeeding();
            }
        }
    }

    public void goToPrisonForSpeeding() {
        System.out.println("Go to prison");
    }
}