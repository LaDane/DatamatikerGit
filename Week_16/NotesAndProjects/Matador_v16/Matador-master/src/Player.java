import java.util.ArrayList;

public class Player {
    //  Implementer en Player klasse. Lav dens konstruktor sådan at den tager et navn
    //  og en saldo. Ret de to steder i koden hvor Player bliver instansieret.

    private String name;                            // Player name
    private BankAccount bankAccount;                // players Bankaccount

    private int id;                                 // Players unique id
    static int counter = 0;                         // Used for unique ID's to players
    private int position=1;                           // Players current position on board (field)
    private int passStartMoney = 4000;              // Money given when a player passes start field
    private int landOnStartMoney = 4000;            // Money given if a player lands on start field
    private ArrayList Deeds = new ArrayList();

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


    /* Methods */
    @Override
    public String toString() {
        return String.format("Player %d:\n" +
                        "\tName:\t\t%s\n" +
                        "\tBalance:\t%d\n",
                id, name, bankAccount.getBalance());
    }

    /* Update player position by adding a dice roll to players current position */
    public int updatePosition(int diceRoll) {
        this.position += diceRoll;


        //When player position exceeds 40 we pass start.
        if(this.position > 40)
        {
            this.position = this.position - 40;
            getMoneyFromBank(passStartMoney);

            // Player has landed on start field
            if (this.position == 1) {
                getMoneyFromBank(landOnStartMoney);
            }
        }
        return this.position;
    }

    public void doTransaction(Player recipient, int amount) {
        // Negative amount: You lose money
        if (recipient == null) {
            if (amount < 0) {
                giveMoneyToBank(amount);
            } else {
                getMoneyFromBank(amount);
            }
        } else {
            doPlayerTransaction(recipient, amount);
        }
    }

    // Take money from current player and give to another player specified in parameter
    public void doPlayerTransaction(Player playerToPay, int amount) {
        if (playerHasEnoughMoney(amount)) {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            playerToPay.bankAccount.setBalance(bankAccount.getBalance() + amount);
        }
    }

    // Get money from bank
    public void getMoneyFromBank(int amount) {

        bankAccount.setBalance(bankAccount.getBalance() + amount);
    }

    // Give money to bank
    public void giveMoneyToBank(int amount) {
        if (playerHasEnoughMoney(amount)) {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
        }
    }

    // Check if player has enough money on their account for the transaction with given amount
    public boolean playerHasEnoughMoney(int amount) {
        if (bankAccount.getBalance() - amount < 0) {
            System.out.println("Player does not have enough money");
            return false;
        }
        return true;
    }



    public int getBalance() {
        return this.getBankAccount().getBalance();
    }
}