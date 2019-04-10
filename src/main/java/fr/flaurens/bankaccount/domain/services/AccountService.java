package fr.flaurens.bankaccount.domain.services;

import fr.flaurens.bankaccount.domain.adapters.AccountDAO;
import fr.flaurens.bankaccount.domain.adapters.OperationDAO;
import fr.flaurens.bankaccount.domain.model.*;
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
    public double makeDepositOnAccount(long accountId, Amount amount){
        Account workingAccount = this.accountDAO.getAccountById(accountId);
        Operation operation = new Deposit(accountId, amount);
        operationDAO.persistOperation(operation);
        return workingAccount.updateBalance(amount.getAmountValue());
    }

    @Transactional
    public double withdrawFromAccount(long accountId, Amount amount){
        Account workingAccount = this.accountDAO.getAccountById(accountId);
        Operation operation = new Withdrawal(accountId, amount);
        operationDAO.persistOperation(operation);
        return workingAccount.updateBalance(-amount.getAmountValue());
    }

    public List<Operation> getAccountHistory(long accountId){
        return operationDAO.getOperationByAccount(accountId);
    }


    public double getCurrentBalance(long accountId){
        Account workingAccount = this.accountDAO.getAccountById(accountId);
        return workingAccount.getBalance();
    }
}
