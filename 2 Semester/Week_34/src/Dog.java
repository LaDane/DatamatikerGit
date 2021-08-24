public class Dog extends Command{
    public void whoAmI() {
        System.out.println("I am a dog");
    }

    @Override
    public void execute() {
        whoAmI();
    }
}
