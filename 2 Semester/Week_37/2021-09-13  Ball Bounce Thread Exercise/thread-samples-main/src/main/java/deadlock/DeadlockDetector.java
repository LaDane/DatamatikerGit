package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector implements Runnable {
    @Override
    public void run() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        while (true) {
            long[] deadlockedThreads = bean.findDeadlockedThreads();
            if (deadlockedThreads != null) {
                System.out.println("Deadlock detected");
                //Stop the detector thread
                Thread.currentThread().interrupt();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.exit(1);
    }
}
