public class Cat extends Animal{
    Cat(int _numberOfLegs) {
        super(_numberOfLegs);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
