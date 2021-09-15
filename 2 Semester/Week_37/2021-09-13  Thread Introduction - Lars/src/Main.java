import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyCounter counter = new MyCounter("Counter");
        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {e.printStackTrace();}

        System.out.println(counter.getSum());
        firstTry();
    }


    private static void firstTry() throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("r1 iteration = "+ i +"\t Thread ="+ Thread.currentThread().getName());
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("r2 iteration = "+ i +"\t Thread ="+ Thread.currentThread().getName());
                }
            }
        };

        Thread t1 = new Thread(r1);
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(r2);
        t2.setName("t2");
        t2.start();

        // we can sleep the main thread, just like we can sleep secondary threads
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // We can also join the thread, in order for the main thread to wait for the secondary thread to finish
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        ExecutorService es = Executors.newFixedThreadPool(4);
        es.execute(r1);
        es.execute(r2);
        es.awaitTermination(4000, TimeUnit.MILLISECONDS);
        es.shutdown();


        System.out.println("Done");
    }
}
