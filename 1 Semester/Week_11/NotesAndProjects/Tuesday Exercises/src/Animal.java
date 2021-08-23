public class Animal implements AnimalSound{

    int numberOfLegs;

    Animal(int _numberOfLegs) {
        this.numberOfLegs = _numberOfLegs;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public void makeSound() {
        System.out.println("Undefined animal makes no sound.");
    }

}
