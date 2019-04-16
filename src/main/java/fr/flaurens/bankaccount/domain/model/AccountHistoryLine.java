package fr.flaurens.bankaccount.domain.model;

import java.time.Instant;
import java.util.Date;

public class AccountHistoryLine {

    private final Operation operation;

    private final Date executionDate;

    private final double balanceBefore;

    private final double balanceAfter;

    public AccountHistoryLine(Operation operation, double balanceBefore, double balanceAfter) throws UnknownOperationTypeException {
        this.executionDate = Date.from(Instant.now());
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
        switch(operation.getOperationType()){
            case Operation.WITHDRAWAL : this.operation = new Withdrawal((Withdrawal) operation);
                       break;
            case Operation.DEPOSIT : this.operation = new Deposit((Deposit) operation);
                      break;
            default : throw new UnknownOperationTypeException("Unknown operation type :"+operation.getOperationType());
        }
    }
}
