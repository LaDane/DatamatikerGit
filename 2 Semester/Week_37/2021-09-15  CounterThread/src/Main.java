import java.time.Duration;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Map<Integer, String> questions = new HashMap<>();
        questions.put(1, "Hvem er Kurt");
        questions.put(2, "Hvem er Verner");
        questions.put(3, "Hvem er Otto");
        questions.put(4, "Hvem er Viffo");
        questions.put(5, "Hvem er Lone");

        MyCounter counter = new MyCounter(questions);

        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);

        t1.start();
        t1.join();
        t2.start();
        t2.join();

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
