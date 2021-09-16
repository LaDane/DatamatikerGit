public class CounterThread extends Thread {

    MyCounter counter;

    public CounterThread(MyCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 1; i < getSizeOfMap(); i++) {
            System.out.println(counter.getQuestion(i));
        }
    }

    private int getSizeOfMap() {
        return counter.questions.size();
    }
}
