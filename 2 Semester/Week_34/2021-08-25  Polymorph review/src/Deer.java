public class Deer extends Command{
    public void sound() {
        System.out.println("Muu");
    }

    @Override
    public void execute() {
        sound();
    }
}
