class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from Thread "+ Thread.currentThread().getName() +" \t 1 = "+ i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        t1.setName("t1");                               // We are able to set a thread name with this method
        Thread t2 = new Thread(new MyRunnable());
        t2.setName("t2");
        t1.start();
        t2.start();

        // If setting a thread to be a Daemon thread (t1.setDaemon(true)) -> Thread will stop when main has reached its end

        t1.join();                                      // Blocking call -> We are able to wait for a thread to be finished before continuing;
        t2.join();

        System.out.println("Who am i? "+ Thread.currentThread().getName());
        System.out.println("Are we done?");
    }
}
