public class Exercise1 extends Thread {
    Even even = new Even();

    private Thread t1 = new Thread(even);
    private Thread t2 = new Thread(even);

    public void exercise1() {
        t1.start();
        t2.start();
    }
}

class Even extends Thread {
    private int n = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(next());
        }
    }

    public synchronized int next() {
        n++;
        try {Thread.sleep(1);}
        catch (InterruptedException e) {e.printStackTrace();}
        n++;
        return n;
    }
}
