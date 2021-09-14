package producerconsumer;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                String msg = queue.take();

                System.out.println("Consumed: " + msg);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
