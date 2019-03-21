package fr.flaurens.bankaccount.model;

public class Account {

    private final long accountId;

    private float balance;

    public Account(long accountId){
        this.accountId = accountId;
        this.balance = 0f;
    }

    public float getBalance(){
        return this.balance;
    }

    public float updateBalance(float amount){
        this.balance += amount;
        return this.balance;
    }
}
