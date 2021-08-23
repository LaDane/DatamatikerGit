public class BankAccount {
    public float saldo;
    private String owner;
    float[] transactions = new float[100];

    public BankAccount(float saldo) {
        this.saldo = saldo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void withdrawAmount(float amount) {
        saldo -= amount;
    }

    @Override
    public String toString() {
        String str;
        str = owner+" : "+saldo;
        return str;
    }
}
