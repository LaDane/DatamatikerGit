public class Property extends Field implements Purchasable {

    int cost, income;

    public Property(int id, String label, int cost, int income) {
        super(id, label);
        this.cost = cost;
        this.income = income;
    }

    public String toString() {
        return "Du er landet på " + this.label + " prisen er " + this.cost;
    }

    //TODO getAction if owned

    public Action getAction(){
        String str = this.toString();
        int amount = this.cost;
        Action a = new Action(str,amount);
        return a;
    }

    @Override
    public void purchase() {

    }

    public void pledge() {
        // pantsæt
    }

    public int getCost() {
        return cost;
    }

    public int getIncome() {
        return income;
    }
}
