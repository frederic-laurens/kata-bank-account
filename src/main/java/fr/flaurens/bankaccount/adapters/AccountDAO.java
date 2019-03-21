package fr.flaurens.bankaccount.adapters;

import fr.flaurens.bankaccount.model.Account;
import org.springframework.stereotype.Component;

@Component
public interface AccountDAO {

    Account getAccountById(long accountId);

    void persistAccount(Account account);
}
