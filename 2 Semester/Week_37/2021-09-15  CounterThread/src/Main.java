import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Map<Integer, String> questions;

        MyCounter counter = new MyCounter("Jeopardy", questions);

        // Create the shared resource
        /*
        MyCounter counter = new MyCounter("Kurt");
        Date d = counter.getCreated();
        System.out.println("Counter created at : "+ d);

        // Create 2 threads that share this resource
        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);

        long startTime = System.currentTimeMillis();

        // Start these 2 threads
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        long endTime = System.currentTimeMillis();
        long runTime = (endTime - startTime);

        System.out.println(counter.getSum() +"\tTook "+ runTime +" ms");
         */
    }
}
