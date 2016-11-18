package com.epam.mentoring;

public class Account {
    // default values: 0 or null
    private int id;
    private String accountHolder;
    private int balance;
    // static variable - id of the latest instance
    private static int latestId;

    public Account(String accountHolder) {
        // generate id instead of set directly
        this.id = ++latestId;
        this.accountHolder = accountHolder;
    }

    public Account(String accountHolder, int balance) {
        // constructor chain, other constructor can be invoked using 'this' keyword
        this(accountHolder);
        this.balance = balance;
    }

    public void credit(int amount) {
        balance += amount;
        System.out.printf("CREDIT - Name: %s, Amount: %d\n", accountHolder, amount);
    }

    public boolean debit(int amount) {
        if(amount <= balance) {
            balance -= amount;
            System.out.printf("DEBIT - Name: %s, Amount: %d\n", accountHolder, amount);
            return true;
        }
        else {
            System.out.printf("DEBIT - Amount exceeded balance. \n\tAmount: %d\n\tBalance: %d\n", amount, balance);
            return false;
        }
    }

    public void transferTo(Account receiverAccount , int amount){
        System.out.printf("TRANSFER - Try to transfer %d huf to %s's account\n", amount, receiverAccount.getAccountHolder());
        if(amount <= balance){
            balance -= amount;
            receiverAccount.balance += amount;
            System.out.println("TRANSFER - Transfer was successful");
        }
        else {
            System.out.printf("TRANSFER - Amount exceeded balance. \n\tAmount: %d\n\tBalance: %d\n", amount, balance);
        }
    }

    // getter-setter - accessors
    // only getter
    public int getId() {
        return id;
    }

    public String getAccountHolder() {
        return accountHolder.toUpperCase();
    }

    public void setAccountHolder(String accountHolder) {
        if(accountHolder != null && !accountHolder.isEmpty()){
            System.out.printf("Changing name: %s -> %s\n", this.accountHolder, accountHolder);
            this.accountHolder = accountHolder;
        }
        else{
            System.out.println("Cannot set empty name");
        }
    }

    public int getBalance() {
        return balance;
    }
}
