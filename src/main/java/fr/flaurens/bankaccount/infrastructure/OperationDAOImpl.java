package fr.flaurens.bankaccount.infrastructure;

import fr.flaurens.bankaccount.domain.adapters.OperationDAO;
import fr.flaurens.bankaccount.domain.model.Operation;

import java.util.List;

public class OperationDAOImpl implements OperationDAO {

    @Override
    public void persistOperation(Operation operation) {

    }

    @Override
    public List<Operation> getOperationByAccount(long accountId) {
        return null;
    }
}
