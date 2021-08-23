public class ElectricCar extends Car{

    private int batteryCapacity;
    private int maxKm;
    private double whPrKm;

    public ElectricCar(String regNumber, String brand, String model, int year, int doors, int batteryCapacity, int maxKm, double whPrKm) {
        super(regNumber, brand, model, year, doors);
        this.batteryCapacity = batteryCapacity;
        this.maxKm = maxKm;
        this.whPrKm = whPrKm;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }
    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getMaxKm() {
        return maxKm;
    }
    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public double getWhPrKm() {
        return whPrKm;
    }
    public void setWhPrKm(double whPrKm) {
        this.whPrKm = whPrKm;
    }

    @Override
    public double calculateTax() {
        double tax = 0;
        double kmPrL = 100/(whPrKm/91.25);

        if (kmPrL <= 5)
            tax = 10470;
        else if (kmPrL > 5 && kmPrL <= 10)
            tax = 5500;
        else if (kmPrL > 10 && kmPrL <= 15)
            tax = 2340;
        else if (kmPrL > 15 && kmPrL <= 20)
            tax = 1050;
        else                // greater than 20 (20 to 50 is included here)
            tax = 330;

        return tax;
    }

    @Override
    public String toString() {
        String returnString =
                "\n\tElectric Car"+
                super.toString() +
                "\n\t\tCar battery capacity: \t"+ getBatteryCapacity() +
                "\n\t\tCar maxKm: \t\t\t\t"+ getMaxKm() +
                "\n\t\tCar whPrKm: \t\t\t"+ getWhPrKm() +
                "\n\t\tCar tax: \t\t\t\t"+ calculateTax();
        return returnString;
    }
}
