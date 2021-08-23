import java.util.InputMismatchException;

public class BankAccount{

    private float balance;
    private String owner;
    private int id;
    private static int counter;

    float[] transactions = new float[100];
    //  ArrayList<Float> transaction = new ArrayList<>();

    public BankAccount(float saldo){
        this.balance = saldo;
        this.id = counter++;            // unique id
    }

    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }

    public float getBalance() {
        return balance;
    }
    public void setBalance(float _balance) { this.balance = _balance; }

    @Override
    public String toString(){
        String str;
        str= owner+" : "+balance;
        return str;
    }

    public void withdraw() {
        Main.withdrawFromAccount(this);
    }
}
