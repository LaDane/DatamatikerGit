public class Main {

    public static String myName = "Aleksander";
    public static String garageName = myName +"'s Garage";
    public static Garage myGarage;

    public static PetrolCar pCar1;
    public static PetrolCar pCar2;
    public static ElectricCar eCar1;
    public static ElectricCar eCar2;
    public static DieselCar dCar1;
    public static DieselCar dCar2;

    public static void main(String[] args) {
        System.out.println();
        createCars();
        createGarage();
        addCarsToGarage();
        printCarsInGarage();
        calculateTotalTax();
    }

    public static void createCars() {
        pCar1 = new PetrolCar("HG-30-2021", "Audi", "A3", 2014, 3, 91, 20);
        pCar2 = new PetrolCar("FM-23-8540", "BMW", "320", 2002, 5, 91, 12);

        eCar1 = new ElectricCar("GH-43-6534", "Tesla", "Model 3", 2019, 5, 9000, 647, 184);
        eCar2 = new ElectricCar("PI-20-9273", "BMW", "i", 2020, 3, 5500, 420, 165);

        dCar1 = new DieselCar("WG-85-3194", "Ford", "F150", 1990, 2, false, 7);
        dCar2 = new DieselCar("TO-72-2378", "Toyota", "Hilux", 2006, 2, true, 12);
    }

    public static void createGarage() {
        myGarage = new Garage(garageName);
    }

    public static void addCarsToGarage() {
        myGarage.addPetrolCar(pCar1);
        myGarage.addPetrolCar(pCar2);
        myGarage.addElectricCar(eCar1);
        myGarage.addElectricCar(eCar2);
        myGarage.addDieselCar(dCar1);
        myGarage.addDieselCar(dCar2);
    }

    public static void printCarsInGarage() {
        System.out.println("Printing all cars in "+ garageName +": ");
        System.out.println(myGarage.toString());
    }

    public static void calculateTotalTax() {
        System.out.println("\nPrinting total tax of cars in "+ garageName +": ");
        System.out.println("\t" +myGarage.calculateTotalGarageTax());
    }
}
