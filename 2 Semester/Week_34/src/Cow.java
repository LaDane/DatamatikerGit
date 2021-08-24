public class Cow extends Command{
    public void whoAmI() {
        System.out.println("I am a cow");
    }

    @Override
    public void execute() {
        whoAmI();
    }
}
