public class Land extends Property {

    public Land(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }

    @Override
    public Action getAction(){
        System.out.println(owner);

        //Hvis feltet ikke er købt TODO Ask if wants to purchase
        if(owner == null) {
            String str = this.toString();
            int amount = this.cost;
            Action a = new Action(str, amount);
            return a;

        //Hvis feltet er ejet af den der lander på det // TODO check if player owns all in same series
        } else if (this.owner.equals(Main.currentPlayer)) {
            String str = "Du er landet på " + this.label + " hvilket du selv ejer";
            Action a = new Action(str);
            return a;
        //hvis feltet er ejet af en anden spiller
        } else {
            String str = "Du er landet på " + this.label + " du skal betale " + this.income + " til " + owner.getName();
            int amount = income;
            int owner = this.owner.getId();
            Action a = new Action(str,amount,owner);
            return a;
        }
    }
}