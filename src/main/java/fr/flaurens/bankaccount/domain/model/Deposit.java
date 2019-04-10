package fr.flaurens.bankaccount.domain.model;

public class Deposit extends Operation {

    public Deposit(long accountId, Amount amount){
        super(accountId, amount);
    }

    @Override
    public String getOperationType() {
        return "deposit";
    }
}
