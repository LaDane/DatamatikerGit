import java.util.concurrent.ArrayBlockingQueue;

public class Handler extends Thread{
    @Override
    public void run() {
        Main.queue = new ArrayBlockingQueue<>(5);
        createProducer();
        createConsumer();
        createConsumer();
        createConsumer();
    }

    private void createConsumer() {
        Thread consumerThread = new Thread(new Consumer());
        consumerThread.start();
    }

    private void createProducer() {
        Thread producerThread = new Thread(new Producer());
        producerThread.start();
    }
}
