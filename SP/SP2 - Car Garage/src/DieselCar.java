public class DieselCar extends Car{

    private boolean hasParticleFilter;
    private int kmPrL;

    public DieselCar(String regNumber, String brand, String model, int year, int doors, boolean hasParticleFilter, int kmPrL) {
        super(regNumber, brand, model, year, doors);
        this.hasParticleFilter = hasParticleFilter;
        this.kmPrL = kmPrL;
    }

    public boolean isHasParticleFilter() {
        return hasParticleFilter;
    }
    public void setHasParticleFilter(boolean hasParticleFilter) {
        this.hasParticleFilter = hasParticleFilter;
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
            tax = 10470 + 15260;
        else if (kmPrL > 5 && kmPrL <= 10)
            tax = 5500 + 2770;
        else if (kmPrL > 10 && kmPrL <= 15)
            tax = 2340 + 1850;
        else if (kmPrL > 15 && kmPrL <= 20)
            tax = 1050 + 1390;
        else                // greater than 20 (20 to 50 is included here)
            tax = 330 + 130;

        if (!hasParticleFilter)
            tax += 1000;

        return tax;
    }

    @Override
    public String toString() {
        String returnString =
                "\n\tDiesel Car"+
                super.toString() +
                "\n\t\tCar has particlefilter: "+ isHasParticleFilter() +
                "\n\t\tCar kmPrL: \t\t\t\t"+ getKmPrL() +
                "\n\t\tCar tax: \t\t\t\t"+ calculateTax();
        return returnString;
    }
}
