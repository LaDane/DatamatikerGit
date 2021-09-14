public class MyCounter {

    private String name;
    private int counter;

    public MyCounter(String name) {
        this.name = name;
        this.counter = 0;
    }

    public void countUp() {
        this.counter = this.counter + 1;
    }

    public int getSum() {
        return this.counter;
    }
}
