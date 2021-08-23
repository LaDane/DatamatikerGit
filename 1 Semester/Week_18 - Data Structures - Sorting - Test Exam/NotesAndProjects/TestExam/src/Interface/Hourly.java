package Interface;

public class Hourly implements Payment{

    private float amountOfHours;
    private double hourlyPay;

    @Override
    public double calculatePayment() {
        return amountOfHours * hourlyPay;
    }
}
