package producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
Remember, main runs in its own thread, so we have two threads in this example
 */
public class Producer  {

    static int lastID = 0;
    public static void produce( BlockingQueue<String> queue) throws InterruptedException {
        String itemProduced = "Hello"+ lastID++;
        queue.put(itemProduced);
        System.out.println("Produced: "+ itemProduced+ " -- QueueSize: "+queue.size());
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        Thread t = new Thread(new Consumer(queue));
        t.start();

        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
//        produce(queue);
//        produce(queue);
//        produce(queue);



        t.join(10000);
        t.interrupt();
        t.join();
        System.out.println("All items Produced and Consumed");

    }

}
