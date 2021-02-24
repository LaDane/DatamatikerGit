class BankAccount {
    double balance = 0;
    String owner = "";
    double[] transactions = {};

    public BankAccount(double _balance, String _owner, double[] _transactions) {
        this.balance = _balance;
        this.owner = _owner;
        this.transactions = _transactions;
    }
}