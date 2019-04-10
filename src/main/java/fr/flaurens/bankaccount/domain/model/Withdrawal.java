package fr.flaurens.bankaccount.domain.model;

public class Withdrawal extends Operation {

    public Withdrawal(long accountId, Amount amount){
        super(accountId, amount);
    }

    public String getOperationType(){
        return "withdrawal";
    }
}
