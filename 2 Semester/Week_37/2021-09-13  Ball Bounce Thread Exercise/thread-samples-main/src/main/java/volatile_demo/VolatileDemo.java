package volatile_demo;



import java.io.IOException;

public class VolatileDemo
{
    public static void main(String[] args) throws IOException, InterruptedException {
        MutableInteger mi = new MutableInteger();

        Thread t1 = new Thread(() -> {
            while (mi.get() == 0) {
                /* Busy Wait */
            }
            System.out.println("String changed, thread terminating");
        });

        t1.start();

        System.out.println("Hit enter to change number");
        System.in.read();

        mi.set(42);
        t1.join();
        System.out.println("Main thread has set mi to 42");
    }
}
