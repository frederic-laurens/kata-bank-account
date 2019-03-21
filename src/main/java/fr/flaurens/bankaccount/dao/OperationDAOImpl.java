package fr.flaurens.bankaccount.dao;

import fr.flaurens.bankaccount.adapters.OperationDAO;
import fr.flaurens.bankaccount.model.Operation;

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
