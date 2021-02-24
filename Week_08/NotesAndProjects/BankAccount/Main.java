class Main {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new BankAccount(30000, "Person1", new double[] {11.11, 11.01});
        accounts[1] = new BankAccount(30000, "Person2", new double[] {22.22, 22.02});
        accounts[2] = new BankAccount(30000, "Person3", new double[] {33.33, 33.03});

        for (int i = 0; i < accounts.length; i++) {
            String t = "";
            
            for (int j = 0; j < accounts[i].transactions.length; j++) {
                t += accounts[i].transactions[j] + "\n";
            }

            System.out.println("Account1 Balance: "+ accounts[i].balance +"\nAccount1 Owner: "+ accounts[i].owner + "\nAccount1 Transactions:\n"+ t);
        } 
    }
}