public class Cat extends Command{
    public void whoAmI() {
        System.out.println("I am a cat");
    }

    @Override
    public void execute() {
        whoAmI();
    }
}
