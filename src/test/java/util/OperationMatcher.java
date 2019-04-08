package util;

import fr.flaurens.bankaccount.domain.model.Operation;
import org.mockito.ArgumentMatcher;

public class OperationMatcher implements ArgumentMatcher<Operation> {

    private final Operation expected;

    public OperationMatcher(Operation expected){
        this.expected = expected;
    }

    @Override
    public boolean matches(Operation actual) {
        return expected.getAmount() == actual.getAmount() &&
                expected.getAccountId() == actual.getAccountId() &&
                //expected.getDate.equals(actual.getDate()) &&
                expected.getOperationType().equals(actual.getOperationType());
    }
}
