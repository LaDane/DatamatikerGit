public class Producer extends Thread{

    Fibonacci fib;

    public Producer() {
        fib = new Fibonacci();
    }

    @Override
    public void run() {
        System.out.println("Producer starting");
        while (!Main.S1.isEmpty()) {
            try {produce();}
            catch (InterruptedException e) {break;}
        }
        System.out.println("S1 is empty! Thread has stopped");
    }

    private void produce() throws InterruptedException {

        int i = Main.S1.take();
        int result = fib.fib(i);
        if (!Main.S2.offer(result)) {
            System.out.println("S2 full!");
            Thread.sleep(100);
        }
        System.out.println("Produced: '"+ result + "' using the Fibonacci value of '" + i + "'");
    }
}
