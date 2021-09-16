import java.util.concurrent.BlockingQueue;

public class Main {

    public static BlockingQueue<String> queue;

    public static void main(String[] args) {

        Thread handlerThread = new Handler();
        handlerThread.start();

//        System.out.println("All items Produced and Consumed");

    }
}
