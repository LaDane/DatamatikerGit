package deadlock.simpledemo;

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        final Object r1 = new Object();
        final Object r2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println("Thread 1: Locked r1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r2) {
                    System.out.println("Thread 1: Locked r2");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (r2) {
                System.out.println("Thread 2: Locked r2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r1) {
                    System.out.println("Thread 2: Locked r1");
                }
            }
        });



        t1.start();
        t2.start();
        //new Thread(....).start(); //You could execute the DeadlockDetector from this thread
        t1.join(3000);
        t2.join(3000);
        String msg1 = t1.getState().toString().equals("BLOCKED") ? "t1 timed out, while blocked. It was most like involved in a  deadlock" : "t1 done";
        String msg2 = t2.getState().toString().equals("BLOCKED") ? "t2 timed out, while blocked. It was most like involved in a  deadlock" : "t2 done";
        System.out.println(msg1 + "\n" + msg2);

        System.out.println("DONE (but have you left the program)");
    }
}