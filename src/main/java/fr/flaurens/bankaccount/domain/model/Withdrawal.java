package fr.flaurens.bankaccount.domain.model;

public class Withdrawal extends Operation {

    public Withdrawal(long accountId, Amount amount){
        super(accountId, amount);
    }

    public Withdrawal(Withdrawal other){
        super(other);
    }

    @Override
    public double calculateIncrement() {
        return -getAmount().getAmountValue();
    }

    public String getOperationType(){
        return Operation.WITHDRAWAL;
    }
}
