public class Exercise3 {
    public static void main(String[] args) throws InterruptedException {
        WorkerCancelable worker = new WorkerCancelable();
        Thread t = new Thread(worker);
        t.start();
        Thread.sleep(3000);
        worker.cancel();
        System.out.println("DONE");
    }
}

class WorkerCancelable implements Runnable{
    boolean keepRunning = true;
    Thread thread;
    public void run() {
        thread = Thread.currentThread();

        while(keepRunning){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void cancel() {
        keepRunning = false;
        if (!thread.isInterrupted()) {

            System.out.println("Thread interrupted");
            thread.interrupt();
        }
    }
}
