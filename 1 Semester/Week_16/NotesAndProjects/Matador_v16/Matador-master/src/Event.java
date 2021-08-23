public class Event extends Consequence {

    public Event(int id, String label) {
        super(id, label);
    }

    public String toString() {
        return "Træk et kort fra bunken";
    }

    @Override
    public Action getAction(){
        String str = this.toString();
        Action a = new Action(str);
        return a;
    }
}

