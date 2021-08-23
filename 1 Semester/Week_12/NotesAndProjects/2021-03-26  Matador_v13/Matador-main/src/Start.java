public class Start extends Consequence {

    int income;

    public Start(int id, String label, int income) {
        super(id, label);
        this.income = income;
    }

    @Override
    public String toString() {
        return "Modtag " + this.income + " når du passerer start";
    }

    public Action getAction(){
        String str = this.toString();
        int amount = this.income;
        Action a = new Action(str,amount);
        return a;
    }
}
