package turnstile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TurnstileTester {

    static final int NUMBER_OF_TURNSTILES = 40;
    static Turnstile[] turnStiles = new Turnstile[NUMBER_OF_TURNSTILES];

    public static void main(String[] args) throws InterruptedException {
        //This is the shared Counter used by ALL turnstiles
        TurnstileCounter sharedCounter = new TurnstileCounter();

        for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
            turnStiles[i] = new Turnstile(sharedCounter);
        }

        //This example uses a ThreadPool to handle threads
        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
            es.execute(turnStiles[i]);
        }

        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("All turnstiles are done");

        System.out.println(sharedCounter.getValue());
    }
}