public class CounterThread extends Thread {

    MyCounter counter;

    public CounterThread(MyCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.countUp();
        }
    }
}
