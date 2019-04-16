package fr.flaurens.bankaccount.domain.model;

import java.time.Instant;
import java.util.Date;

public abstract class Operation {

    private final long accountId;

    private final Amount amount;

    private final Date date;

    public static final String DEPOSIT = "deposit";

    public static final String WITHDRAWAL = "withdrawal";

    public Operation(long accountId, Amount amount){
        this.accountId = accountId;
        this.amount = amount;
        this.date = Date.from(Instant.now());
    }

    public Operation(Operation other){
        this.accountId = other.accountId;
        this.amount = other.amount;
        this.date = other.date;
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

    public abstract double calculateIncrement();

    public abstract  String getOperationType();
}
