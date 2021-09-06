public class Konto {
    private String name;
    private int balance;

    public Konto(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int insert(int i) {
        this.balance += i;
        if (this.balance < 0) {
            this.balance = 0;
        }
        return this.balance;
    }

    public int withdraw(int i) {
        if (this.balance - i < 0 || i <= 0 || i >= 25000 || i%50 != 0) {
            return -1;
        }
        this.balance -= i;
        return balance;
    }
}
