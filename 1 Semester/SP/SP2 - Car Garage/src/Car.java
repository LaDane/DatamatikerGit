public abstract class Car {
    private String regNumber;
    private String brand;
    private String model;
    private int year;
    private int doors;

    public Car(String regNumber, String brand, String model, int year, int doors) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.doors = doors;
    }

    public String getRegNumber() {
        return regNumber;
    }
    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getDoors() {
        return doors;
    }
    public void setDoors(int doors) {
        this.doors = doors;
    }

    public abstract double calculateTax();

    @Override
    public String toString() {
        return
            "\n\t\tRegistration number: \t"+ getRegNumber() +
            "\n\t\tCar brand: \t\t\t\t"+ getBrand() +
            "\n\t\tCar model: \t\t\t\t"+ getModel() +
            "\n\t\tCar year: \t\t\t\t"+ getYear() +
            "\n\t\tCar doors: \t\t\t\t"+ getDoors();
    }
}
