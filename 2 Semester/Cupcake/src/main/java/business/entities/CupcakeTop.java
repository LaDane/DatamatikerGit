package business.entities;

public class CupcakeTop {

    int cupcakeTopId;
    String cupcakeTopName;
    double cupcakeTopPrice;

    public CupcakeTop(int cupcakeTopId, String cupcakeTopName, double cupcakeTopPrice) {
        this.cupcakeTopId = cupcakeTopId;
        this.cupcakeTopName = cupcakeTopName;
        this.cupcakeTopPrice = cupcakeTopPrice;
    }

    public int getCupcakeTopId() {
        return cupcakeTopId;
    }

    public void setCupcakeTopId(int cupcakeTopId) {
        this.cupcakeTopId = cupcakeTopId;
    }

    public String getCupcakeTopName() {
        return cupcakeTopName;
    }

    public void setCupcakeTopName(String cupcakeTopName) {
        this.cupcakeTopName = cupcakeTopName;
    }

    public double getCupcakeTopPrice() {
        return cupcakeTopPrice;
    }

    public void setCupcakeTopPrice(double cupcakeTopPrice) {
        this.cupcakeTopPrice = cupcakeTopPrice;
    }
}
