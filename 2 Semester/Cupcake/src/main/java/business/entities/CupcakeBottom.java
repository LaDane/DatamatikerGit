package business.entities;

public class CupcakeBottom {

    private int cupcakeBottomId;
    private String cupcakeBottomName;
    private double cupcakeBottomPrice;

    public CupcakeBottom(int cupcakeBottomId, String cupcakeBottomName, double cupcakeBottomPrice) {
        this.cupcakeBottomId = cupcakeBottomId;
        this.cupcakeBottomName = cupcakeBottomName;
        this.cupcakeBottomPrice = cupcakeBottomPrice;
    }

    public int getCupcakeBottomId() {
        return cupcakeBottomId;
    }

    public void setCupcakeBottomId(int cupcakeBottomId) {
        this.cupcakeBottomId = cupcakeBottomId;
    }

    public String getCupcakeBottomName() {
        return cupcakeBottomName;
    }

    public void setCupcakeBottomName(String cupcakeBottomName) {
        this.cupcakeBottomName = cupcakeBottomName;
    }

    public double getCupcakeBottomPrice() {
        return cupcakeBottomPrice;
    }

    public void setCupcakeBottomPrice(double cupcakeBottomPrice) {
        this.cupcakeBottomPrice = cupcakeBottomPrice;
    }
}
