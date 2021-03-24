import java.util.ArrayList;

public class Garage {
    private String garageName;
    private ArrayList<Car> parkedCars = new ArrayList<>();

    private ArrayList<PetrolCar> parkedPetrolCars = new ArrayList<>();
    private ArrayList<ElectricCar> parkedElectricCars = new ArrayList<>();
    private ArrayList<DieselCar> parkedDieselCars = new ArrayList<>();

    public Garage(String garageName) {
        this.garageName = garageName;
    }

    public void addCarToGarage(Car car) {
        parkedCars.add(car);
    }

    public void addPetrolCar(PetrolCar pCar) {
        parkedPetrolCars.add(pCar);
        addCarToGarage(pCar);
    }

    public void addElectricCar(ElectricCar eCar) {
        parkedElectricCars.add(eCar);
        addCarToGarage(eCar);
    }

    public void addDieselCar(DieselCar dCar) {
        parkedDieselCars.add(dCar);
        addCarToGarage(dCar);
    }

    @Override
    public String toString() {
        int totalCars = 0;

        for (Car car : parkedCars) {
            totalCars++;
        }

        String cars = "\tTotal Cars in "+ garageName +" = "+ totalCars;

        for (PetrolCar pCar : parkedPetrolCars) {
            cars += pCar.toString();
        }
        for (ElectricCar eCar : parkedElectricCars) {
            cars += eCar.toString();
        }
        for (DieselCar dCar : parkedDieselCars) {
            cars += dCar.toString();
        }

        return cars;
    }

    public double calculateTotalGarageTax() {
        double totalTax = 0;

        for (Car car : parkedCars) {
            totalTax += car.calculateTax();
        }

        return totalTax;
    }
}
