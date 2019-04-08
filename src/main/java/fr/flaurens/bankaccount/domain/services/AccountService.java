package fr.flaurens.bankaccount.domain.services;

import fr.flaurens.bankaccount.domain.adapters.AccountDAO;
import fr.flaurens.bankaccount.domain.adapters.OperationDAO;
import fr.flaurens.bankaccount.domain.model.Account;
import fr.flaurens.bankaccount.domain.model.Operation;
import fr.flaurens.bankaccount.domain.model.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class AccountService {

    private final AccountDAO accountDAO;

    private final OperationDAO operationDAO;

    public AccountService(@Autowired AccountDAO accountDAO, @Autowired OperationDAO operationDAO){
        this.accountDAO = accountDAO;
        this.operationDAO = operationDAO;
    }

    @Transactional
    public double makeDepositOnAccount(long accountId, double amount){
        Account workingAccount = this.accountDAO.getAccountById(accountId);
        Operation operation = new Operation(accountId, amount, OperationType.DEPOSIT);
        operationDAO.persistOperation(operation);
        return workingAccount.updateBalance(amount);
    }

    @Transactional
    public double retrieveFromAccount(long accountId, double amount){
        Account workingAccount = this.accountDAO.getAccountById(accountId);
        Operation operation = new Operation(accountId, amount, OperationType.WITHDRAWAL);
        operationDAO.persistOperation(operation);
        return workingAccount.updateBalance(-amount);
    }

    public List<Operation> getAccountHistory(long accountId){
        return operationDAO.getOperationByAccount(accountId);
    }


    public double getCurrentBalance(long accountId){
        Account workingAccount = this.accountDAO.getAccountById(accountId);
        return workingAccount.getBalance();
    }
}
