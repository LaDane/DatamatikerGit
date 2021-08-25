public class Dog extends Command{
    public void bark() {
        System.out.println("Bark bark");
    }

    @Override
    public void execute() {
        bark();
    }
}
