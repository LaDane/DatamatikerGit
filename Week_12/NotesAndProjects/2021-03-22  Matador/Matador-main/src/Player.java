import java.util.ArrayList;

public class Player {
    //  Implementer en Player klasse. Lav dens konstruktor sådan at den tager et navn
    //  og en saldo. Ret de to steder i koden hvor Player bliver instansieret.
    private String name;
    private BankAccount bankAccount;
    private int id;
    static int counter = 0;
    private int position;

    private ArrayList<Property> properties;

    public Player(String name, int balance) {
        this.name = name;
        this.id = counter;
        this.bankAccount = new BankAccount(balance);
        counter++;
    }

    /* Getters and setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("Player %d:\n" +
                             "\tName:\t\t%s\n" +
                             "\tBalance:\t%d\n",
                             id, name, bankAccount.getBalance());
    }

    public void updatePosition(int diceRoll)
    {
        this.position += diceRoll;

        //When player position exceeds 40 we pass start.
        if(this.position > 40)
        {
            this.position = this.position - 40;
            getMoneyFromBank(4000);

            // Player has landed on start field
            if (this.position == 1) {
                getMoneyFromBank(4000);
            }
        }
    }

    // take money from current player and give to another player specified in parameter
    public void doPlayerTransaction(Player playerToPay, int amount)
    {
        if (bankAccount.getBalance() - amount < 0) {
            System.out.println("Player does not have enough money");
            return;
        }
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        playerToPay.bankAccount.setBalance(bankAccount.getBalance() + amount);
    }

    // get money from bank
    public void getMoneyFromBank(int amount) {
        bankAccount.setBalance(bankAccount.getBalance() + amount);
    }

    // give money to bank
    public void giveMoneyToBank(int amount) {
        bankAccount.setBalance(bankAccount.getBalance() - amount);
    }
}
