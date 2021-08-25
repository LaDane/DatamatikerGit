public class Hippo extends Command{
    public void jump() {
        System.out.println("Splash");
    }

    @Override
    public void execute() {
        jump();
    }
}
