class Consumer implements Runnable {

    public Consumer() {}

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                String msg = Main.queue.take();

                System.out.println("Consumed: "+ msg +" -- QueueSize: "+Main.queue.size());
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
