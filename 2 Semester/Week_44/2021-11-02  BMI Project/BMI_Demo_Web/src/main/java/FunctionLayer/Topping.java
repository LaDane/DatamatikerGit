package FunctionLayer;

public class Topping {

    private int toppindId;
    private String name;
    private double price;

    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Topping(int toppindId, String name, double price) {
        this.toppindId = toppindId;
        this.name = name;
        this.price = price;
    }

    public int getToppindId() {
        return toppindId;
    }

    public void setToppindId(int toppindId) {
        this.toppindId = toppindId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
