public class Car extends Command{
    public void drive() {
        System.out.println("Vroom vroom");
    }

    @Override
    public void execute() {
        drive();
    }
}
