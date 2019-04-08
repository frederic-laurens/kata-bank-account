package fr.flaurens.bankaccount.domain.adapters;

import fr.flaurens.bankaccount.domain.model.Account;
import org.springframework.stereotype.Component;

@Component
public interface AccountDAO {

    Account getAccountById(long accountId);

    void persistAccount(Account account);

}
