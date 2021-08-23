abstract public class Property extends Field {
    private int cost;
    private int income;
    protected Player owner;
    int seriesID;
    protected String doYouWantToBuyStr;
    protected String alreadyOwnedStr;
    protected String ownedByAnotherPlayerStr;
    public Property(int id, String label, int cost, int income, int seriesID) {
        super(id, label);
        this.cost = cost;
        this.income = income;
        this.seriesID = seriesID;
    }

    private void setMessages() {
       doYouWantToBuyStr = Controller.currentPlayer.getName()+" er landet på " + this.label + " prisen er " + this.cost + ".\n Vil du købe? Y/N: \n";
       alreadyOwnedStr = Controller.currentPlayer.getName()+" er landet på "+this.label+" som du ejer\n Tast y for at fortsætte:";
       try{
       ownedByAnotherPlayerStr = Controller.currentPlayer.getName()+" er landet på "+this.label+" som ejes af "+ owner.getName() + " Der skal betales " +this.income+" til ejeren.\n Tast Y for at betale:\n" ;
       }catch(NullPointerException e){
           System.out.println("The field is not yet owned by anybody");
       }
    }

    public String toString() {
        return "'Property'- felt \n navn:" + this.label + " \n prisen: " + this.cost + "\n indtjening: " +this.income;
    }

    //TODO getAction if owned

    public Action getAction(){
        setMessages();
        Action a = new Action();
        if (owner == null) {
            a.setMsg(doYouWantToBuyStr);
            a.setResponseMsg("buy");
        } else if (owner == Controller.currentPlayer) {
            a.setMsg(alreadyOwnedStr);
            a.setResponseMsg(null);
        } else {
            a.setMsg(ownedByAnotherPlayerStr);
            a.setResponseMsg("pay");
        }

        return a;
    }

    public void updateOwnership(Player owner) {
        this.owner = owner;

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
    public Player getOwner() {
        return owner;
    }

    public String getLabel() {
        return label;
    }
}
