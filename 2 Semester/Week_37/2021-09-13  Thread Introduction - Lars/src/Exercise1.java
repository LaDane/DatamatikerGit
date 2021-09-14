public class Exercise1 {
    public static boolean task3Running = false;

    public static void main(String[] args) {
        Task1 t1 = new Task1();
        Task2 t2 = new Task2();
        Task3 t3 = new Task3();

        t1.start();
        t2.start();
        t3.start();
        task3Running = true;
        try {Thread.sleep(10000);}
        catch (InterruptedException e) {e.printStackTrace();}
        task3Running = false;
    }
}

class Task1 extends Thread {
    @Override
    public void run() {
        long sum = 0;
        for (long i = 0; i < 1000000000; i++) {
            sum = sum + i;
            //System.out.println("Task1 sum = "+ sum);
        }
        System.out.println(sum);
    }
}

class Task2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Task2 num = "+ i);
            try {Thread.sleep(2000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}

class Task3 extends Thread {
    @Override
    public void run() {
        long currentNum = 10;
        while (Exercise1.task3Running) {
            currentNum = currentNum + 1;
            System.out.println("Task3 num = "+ currentNum);
            try {Thread.sleep(3000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}