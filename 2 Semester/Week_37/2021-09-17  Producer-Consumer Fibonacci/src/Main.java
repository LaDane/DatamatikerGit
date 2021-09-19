import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    private static final ArrayList<Integer> S1Ints = new ArrayList<>(Arrays.asList(4, 5, 8, 12, 21, 22, 34, 35, 42));
    public static BlockingQueue<Integer> S1 = new ArrayBlockingQueue<>(9);
    public static BlockingQueue<Integer> S2 = new ArrayBlockingQueue<>(9);

    public static void main(String[] args) {
        fillS1();

        Thread P1 = createProCon(true);
        Thread P2 = createProCon(true);
        Thread P3 = createProCon(true);
        Thread P4 = createProCon(true);

        Thread C1 = createProCon(false);
    }

    private static void fillS1() {
        S1.addAll(S1Ints);
    }

    private static Thread createProCon(boolean isProducer) {
        Thread thread = (isProducer) ? new Thread(new Producer()) : new Thread(new Consumer());
        thread.start();
        return thread;
    }
}
