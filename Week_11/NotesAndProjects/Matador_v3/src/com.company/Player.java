package com.company;

public class Player {
   private BankAccount account;

   static float startBalance = 30000f;

   public Player() {
      account = new BankAccount(startBalance);
      //Main.players.add(account);
   }

   public BankAccount getAccount() {
      return account;
   }

   public void setAccount(BankAccount account) {
      this.account = account;
   }

   @Override
   public String toString(){
      return "Account: " + account;
   }

}
