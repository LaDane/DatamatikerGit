public class BankAccount {
    private int balance;

    public BankAccount (int balance) {
        this.balance = balance;
    }

    public int withdrawAmount(int amount) {
        this.balance -= amount;
        return amount;
    }

    public void receiveAmount(int amount) {
        this.balance += amount;
    }

    public void payPlayer(int amount, Player recipient) {
        this.balance -= amount;
        recipient.getBankAccount().receiveAmount(amount);
    }

    public void payAmountToBank(int amount) {
        this.balance -= amount;
    }

    public void depositAmount(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
