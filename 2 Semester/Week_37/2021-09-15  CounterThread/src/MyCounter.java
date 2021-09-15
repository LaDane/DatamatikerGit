import java.util.Date;
import java.util.Map;

public class MyCounter {

    private String name;
    private int counter;
    private final Date created;
    private Map<Integer,String > questions;

    public MyCounter(String name, Map<Integer, String> questions) {
        this.name = name;
        this.counter = 0;
        this.created = new Date();
        this.questions = questions;
    }

    public synchronized void countUp() {
        this.counter = this.counter + 1;
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }
    }

    public String getQuestion(int index) {
        if (questions.containsKey(index)) {
            return questions.get(index);
        }
        else {
            return "Nothing is on this index";
        }
    }

    public int getSum() {
        return this.counter;
    }

    public Date getCreated() {
        return created;
    }
}
