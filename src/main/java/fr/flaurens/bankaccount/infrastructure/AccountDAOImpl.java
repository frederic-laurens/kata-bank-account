package fr.flaurens.bankaccount.infrastructure;

import fr.flaurens.bankaccount.domain.adapters.AccountDAO;
import fr.flaurens.bankaccount.domain.model.Account;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public Account getAccountById(long accountId) {
        return null;
    }

    @Override
    public void persistAccount(Account account) {

    }
}
