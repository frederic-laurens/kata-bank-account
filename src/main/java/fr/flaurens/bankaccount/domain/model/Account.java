package fr.flaurens.bankaccount.domain.model;

public class Account {

    private final long accountId;

    private double balance;

    public Account(long accountId){
        this.accountId = accountId;
        this.balance = 0f;
    }

    public double getBalance(){
        return this.balance;
    }

    public double updateBalance(double amount){
        this.balance += amount;
        return this.balance;
    }
}
