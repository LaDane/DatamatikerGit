public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        new Exercise1().exercise1();

        long endTime = System.currentTimeMillis();
        long runTime = (endTime - startTime);
        System.out.println("DONE "+ runTime +" ms");
    }
}
