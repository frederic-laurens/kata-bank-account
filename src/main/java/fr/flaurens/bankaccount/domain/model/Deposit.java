package fr.flaurens.bankaccount.domain.model;

public class Deposit extends Operation {

    public Deposit(long accountId, Amount amount){
        super(accountId, amount);
    }

    public Deposit(Deposit other){
        super(other);
    }

    @Override
    public double calculateIncrement() {
        return getAmount().getAmountValue();
    }

    @Override
    public String getOperationType() {
        return Operation.DEPOSIT;
    }
}
