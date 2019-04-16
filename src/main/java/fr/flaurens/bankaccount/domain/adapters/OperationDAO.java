package fr.flaurens.bankaccount.domain.adapters;


import fr.flaurens.bankaccount.domain.model.AccountNotFoundException;
import fr.flaurens.bankaccount.domain.model.Operation;
import java.util.List;

public interface OperationDAO {

    void persistOperation(Operation operation);

    List<Operation> getOperationByAccount(long accountId) throws AccountNotFoundException;
}
