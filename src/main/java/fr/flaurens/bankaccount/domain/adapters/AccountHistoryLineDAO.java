package fr.flaurens.bankaccount.domain.adapters;

import fr.flaurens.bankaccount.domain.model.AccountHistoryLine;
import fr.flaurens.bankaccount.domain.model.AccountNotFoundException;

import java.util.List;

public interface AccountHistoryLineDAO {

    void persistAccountHistoryLine(AccountHistoryLine accountHistoryLine);

    List<AccountHistoryLineDAO> getOperationByAccount(long accountId) throws AccountNotFoundException;
}
