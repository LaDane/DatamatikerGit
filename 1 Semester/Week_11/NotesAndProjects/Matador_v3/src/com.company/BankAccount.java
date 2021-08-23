
package com.company;

public class BankAccount{
    public float balance;
    private String owner;
    //todo: Er denne overhovedet nødvendig? Slet evt. Eller lav om til en ArrayList

    float[] transactions = new float[100];


    public BankAccount(float saldo){
        this.balance = saldo;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }
    public String getOwner(){
        return owner;
    }

    @Override
    public String toString(){
        String str;
        str= owner+" : "+ balance;
        return str;
    }

    public void withdrawAmount(int amount) {
       balance = balance -amount;
    }

    public float getBalance() {
        return this.balance;
    }
}
