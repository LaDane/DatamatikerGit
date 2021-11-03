public class Bil extends Command{

    public void kør() {
        System.out.println("vrooom vroom");
    }

    @Override
    void execute() {
        kør();
    }
}
