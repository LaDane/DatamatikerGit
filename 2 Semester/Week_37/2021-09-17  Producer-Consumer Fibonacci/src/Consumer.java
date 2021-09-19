public class Consumer extends Thread{

    static int total = 0;

    public Consumer() {}

    @Override
    public void run() {
        while (true) {
            try {retrieveAndPrint();}
            catch (InterruptedException e) {break;}
        }
    }

    private void retrieveAndPrint() throws InterruptedException {
        int i = Main.S2.take();
        total = total + i;
        System.out.println("Added '"+ i +"' to the total sum of Fibonacci sequence. New total = '"+ total + "'");
    }
}
