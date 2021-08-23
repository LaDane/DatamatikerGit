public class Cow extends Animal{
    Cow(int _numberOfLegs) {
        super(_numberOfLegs);
    }

    @Override
    public void makeSound() {
        System.out.println("MUUUU!");
    }
}

