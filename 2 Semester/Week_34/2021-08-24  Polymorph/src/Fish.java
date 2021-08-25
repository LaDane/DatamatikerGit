public class Fish extends Command{
    public void whoAmI() {
        System.out.println("I am a fish");
    }

    @Override
    public void execute() {
        whoAmI();
    }
}
