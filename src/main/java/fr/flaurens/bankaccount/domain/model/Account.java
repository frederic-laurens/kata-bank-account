package fr.flaurens.bankaccount.domain.model;

public class Account {

    private final long accountId;

    private double balance;

    public Account(long accountId){
        this.accountId = accountId;
        this.balance = 0d;
    }

    public double getBalance(){
        return this.balance;
    }

    public double updateBalance(double amount){
        this.balance += amount;
        return this.balance;
    }

    public boolean overdraft(){
        return balance < 0d;
    }
}
