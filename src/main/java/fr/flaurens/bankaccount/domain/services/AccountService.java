package fr.flaurens.bankaccount.domain.services;

import fr.flaurens.bankaccount.domain.adapters.AccountDAO;
import fr.flaurens.bankaccount.domain.adapters.AccountHistoryLineDAO;
import fr.flaurens.bankaccount.domain.adapters.OperationDAO;
import fr.flaurens.bankaccount.domain.model.*;


import java.util.List;

public class AccountService {

    private final AccountDAO accountDAO;

    private final OperationDAO operationDAO;

    private final AccountHistoryLineDAO historyLineDAO;

    public AccountService(AccountDAO accountDAO, OperationDAO operationDAO, AccountHistoryLineDAO historyLineDAO){
        this.accountDAO = accountDAO;
        this.operationDAO = operationDAO;
        this.historyLineDAO = historyLineDAO;

    }

    public double makeDepositOnAccount(long accountId, Amount amount) throws AccountNotFoundException, UnknownOperationTypeException {
            Account workingAccount = this.accountDAO.getAccountById(accountId);
            Operation operation = new Deposit(accountId, amount);
            operationDAO.persistOperation(operation);
            return processOperation(workingAccount, operation);
    }


    public double withdrawFromAccount(long accountId, Amount amount) throws AccountNotFoundException, UnknownOperationTypeException {
            Account workingAccount = this.accountDAO.getAccountById(accountId);
            Operation operation = new Withdrawal(accountId, amount);
            operationDAO.persistOperation(operation);
            return processOperation(workingAccount, operation);
    }

    private double processOperation(Account workingAccount, Operation operation) throws UnknownOperationTypeException {
        double balanceBefore = workingAccount.getBalance();
        double balanceAfter = workingAccount.updateBalance(operation.calculateIncrement());
        AccountHistoryLine historyLine = new AccountHistoryLine(operation, balanceBefore, balanceAfter);
        historyLineDAO.persistAccountHistoryLine(historyLine);

        return balanceAfter;
    }

    public List<Operation> getAccountHistory(long accountId) throws AccountNotFoundException {
        return operationDAO.getOperationByAccount(accountId);
    }


    public double getCurrentBalance(long accountId) throws AccountNotFoundException {
        Account workingAccount = this.accountDAO.getAccountById(accountId);
        return workingAccount.getBalance();
    }
}
