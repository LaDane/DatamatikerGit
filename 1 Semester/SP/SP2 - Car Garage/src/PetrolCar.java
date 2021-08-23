public class PetrolCar extends Car{

    private int octane;
    private int kmPrL;

    public PetrolCar(String regNumber, String brand, String model, int year, int doors, int octane, int kmPrL) {
        super(regNumber, brand, model, year, doors);
        this.octane = octane;
        this.kmPrL = kmPrL;
    }

    public int getOctane() {
        return octane;
    }
    public void setOctane(int octane) {
        this.octane = octane;
    }

    public int getKmPrL() {
        return kmPrL;
    }
    public void setKmPrL(int kmPrL) {
        this.kmPrL = kmPrL;
    }

    @Override
    public double calculateTax() {
        double tax = 0;

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
                "\n\tPetrol Car"+
                super.toString() +
                "\n\t\tCar octane: \t\t\t"+ getOctane() +
                "\n\t\tCar kmPrL: \t\t\t\t"+ getKmPrL() +
                "\n\t\tCar tax: \t\t\t\t"+ calculateTax();
        return returnString;
    }
}
