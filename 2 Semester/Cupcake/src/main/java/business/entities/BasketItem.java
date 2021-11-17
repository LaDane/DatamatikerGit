package business.entities;

public class BasketItem {

    private Cupcake cupcake;
    private int amount;
    private double total;

    public BasketItem(Cupcake cupcake, int amount, double total) {
        this.cupcake = cupcake;
        this.amount = amount;
        this.total = total;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public void setCupcake(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

    public String getCupcakeBottomName() {
        return cupcake.getCupcakeBottom().getCupcakeBottomName();
    }

    public String getCupcakeTopName() {
        return cupcake.getCupcakeTop().getCupcakeTopName();
    }

    public int getCupcakeBottomId() {
        return cupcake.getCupcakeBottom().getCupcakeBottomId();
    }

    public int getCupcakeTopId() {
        return cupcake.getCupcakeTop().getCupcakeTopId();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
