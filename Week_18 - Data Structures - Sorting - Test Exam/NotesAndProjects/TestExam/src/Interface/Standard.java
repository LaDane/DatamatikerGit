package Interface;

public class Standard implements Payment{

    private double montlyPayment;

    @Override
    public double calculatePayment() {
        return montlyPayment;
    }
}
