package business.entities;

public class Cupcake {

    private CupcakeBottom cupcakeBottom;
    private CupcakeTop cupcakeTop;
    private double cupcakePrice;

    public Cupcake(CupcakeBottom cupcakeBottom, CupcakeTop cupcakeTop, double cupcakePrice) {
        this.cupcakeBottom = cupcakeBottom;
        this.cupcakeTop = cupcakeTop;
        this.cupcakePrice = cupcakePrice;
    }

    public CupcakeBottom getCupcakeBottom() {
        return cupcakeBottom;
    }

    public void setCupcakeBottom(CupcakeBottom cupcakeBottom) {
        this.cupcakeBottom = cupcakeBottom;
    }

    public CupcakeTop getCupcakeTop() {
        return cupcakeTop;
    }

    public void setCupcakeTop(CupcakeTop cupcakeTop) {
        this.cupcakeTop = cupcakeTop;
    }

    public double getCupcakePrice() {
        return cupcakePrice;
    }

    public void setCupcakePrice(double cupcakePrice) {
        this.cupcakePrice = cupcakePrice;
    }
}
