package fr.flaurens.bankaccount.domain.adapters;


import fr.flaurens.bankaccount.domain.model.Operation;
import org.springframework.stereotype.Component;

import java.util.List;

public interface OperationDAO {

    void persistOperation(Operation operation);

    List<Operation> getOperationByAccount(long accountId);
}
