package fr.flaurens.bankaccount.domain.adapters;

import fr.flaurens.bankaccount.domain.model.Account;
import fr.flaurens.bankaccount.domain.model.AccountNotFoundException;

public interface AccountDAO {

    Account getAccountById(long accountId) throws AccountNotFoundException;

    void persistAccount(Account account);

}
