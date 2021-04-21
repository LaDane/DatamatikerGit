public class Tax extends Consequence {



    int cost;

    public Tax(int id, String label, int cost) {
        super(id, label);
        this.cost = cost;
    }

    public String toString() {
        return "Du er landet på " + this.label + ". Du skal betale " + this.cost;
    }

    public Action getAction(){
        //todo: i reglerne står der at man her får muligheden for atvælge om man vil betale et fast beløb eller 10 % af sine samlede værdier.
        Action a = new Action();
        a.setMsg(this.toString()+". Betal? Y/N:");
        a.setResponseMsg("pay set amount");
        return a;
    }
    public int getCost() {
        return cost;
    }
}
