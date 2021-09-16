import java.util.Date;
import java.util.Map;

public class MyCounter extends Thread{

    private String name;
    private int counter;
//    private final Date created;
    public Map<Integer,String > questions;

    public MyCounter(Map<Integer, String> questions) {
//        this.name = name;
        this.counter = 0;
//        this.created = new Date();
        this.questions = questions;
    }

    public String getQuestion(int index) {
        String question = "";
        if (questions.containsKey(index)) {
            try {
                Thread.sleep((int)(Math.random()+20));
            }
            catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            question = questions.getOrDefault(index, "Nothing is on this index");
            question = questions.remove(index);
            System.out.println(question);
        }
        return "";
    }

//    public synchronized void countUp() {
//        this.counter = this.counter + 1;
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }
//    }

    public int getSum() {
        return this.counter;
    }

//    public Date getCreated() {
//        return created;
//    }
}
