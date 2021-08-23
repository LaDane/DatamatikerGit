public class Tax extends Consequence {

    int cost;

    public Tax(int id, String label, int cost) {
        super(id, label);
        this.cost = cost;
    }

    public String toString() {
        return "Du er landet på " + this.label + " du skal betale " + this.cost;
    }

    public Action getAction(){
        String str = this.toString();
        int amount = this.cost;
        Action a = new Action(str,amount);
        return a;
    }

}
