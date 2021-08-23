import java.util.ArrayList;

public class Zoo {
    ArrayList<Animal> animals = new ArrayList<Animal>();

    public void makeAllSounds() {
        for (Animal a : animals) {
            a.makeSound();
        }
    }

    public void addAnimal(Animal newAnimal) {
        animals.add(newAnimal);
    }

    public void printNumberOfLegs() {
        int totalNumberLegs = 0;

        for (Animal a : animals) {
            totalNumberLegs += a.getNumberOfLegs();
        }

        System.out.println("Total number of legs in my zoo: "+ totalNumberLegs);
    }
}
