package fr.flaurens.bankaccount.domain.model;

import java.util.Date;

public abstract class Operation {

    private final long accountId;

    private final Amount amount;

    private final Date date;

    public Operation(long accountId, Amount amount){
        this.accountId = accountId;
        this.amount = amount;
        this.date = new Date();
    }

    public long getAccountId(){
        return accountId;
    }

    public Amount getAmount(){
        return amount;
    }

    public Date getDate(){
        return date;
    }

    public abstract  String getOperationType();
}
