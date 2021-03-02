import java.util.InputMismatchException;

public class BankAccount{
    private float saldo;
    private String owner;
    private int id;
    private static int counter;

    float[] transactions = new float[100];
    //  ArrayList<Float> transaction = new ArrayList<>();

    public BankAccount(float saldo){
        this.saldo = saldo;
        this.id = counter++;            // unique id
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getOwner(){
        return owner;
    }

    public float getSaldo() {
        return saldo;
    }

    @Override
    public String toString(){
        String str;
        str= owner+" : "+saldo;
        return str;
    }

    public void withDrawAmount() {
        int input=0;

        try {
            input = Integer.parseInt( Main.getUserInput("Træk beløb:"));
        }catch (InputMismatchException e){
            System.out.println(e.toString());
            input = Integer.parseInt( Main.getUserInput("Træk beløb:"));
        }
        this.saldo = saldo-input;
    }
}
