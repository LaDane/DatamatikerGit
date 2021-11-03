public class Hund extends Command{

    public void hyl() {
        System.out.println("hyyyl");
    }

    @Override
    void execute() {
        hyl();
    }
}
