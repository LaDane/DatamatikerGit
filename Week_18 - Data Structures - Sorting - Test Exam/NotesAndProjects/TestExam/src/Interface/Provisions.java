package Interface;

public class Provisions implements Payment{

    private double basePayment;
    private int sales;
    private int provision;

    @Override
    public double calculatePayment() {
        return basePayment + (sales * provision);
    }
}
