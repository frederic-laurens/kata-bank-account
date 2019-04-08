package fr.flaurens.bankaccount.model;

import java.util.Date;

public class Operation {

    private final long accountId;

    private final double amount;

    private final Date date;

    private final OperationType operationType;

    public Operation(long accountId, double amount, OperationType operationType){
        this.accountId = accountId;
        this.amount = amount;
        this.operationType = operationType;
        this.date = new Date();
    }

    public long getAccountId(){
        return accountId;
    }

    public double getAmount(){
        return amount;
    }

    public Date getDate(){
        return date;
    }

    public OperationType getOperationType (){ return operationType;}
}
