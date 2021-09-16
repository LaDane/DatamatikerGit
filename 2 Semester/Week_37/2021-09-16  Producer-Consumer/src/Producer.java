public class Producer extends Thread {

    static int lastID = 0;

    public Producer() {}

    @Override
    public void run() {
        while (true) {
            try {produce();}
            catch (InterruptedException e) {break;}
        }
    }

    public void produce() throws InterruptedException {
        String itemProduced = "Hello"+ lastID++;
//        Main.queue.put(itemProduced);
        if (!Main.queue.offer(itemProduced)) {
            System.out.println("Queue full -> Waiting...");
            Thread.sleep(100);
        }
        System.out.println("Produced: "+ itemProduced+ " -- QueueSize: "+Main.queue.size());
    }
}
