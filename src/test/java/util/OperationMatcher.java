package util;

import fr.flaurens.bankaccount.domain.model.Operation;
import org.mockito.ArgumentMatcher;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationMatcher implements ArgumentMatcher<Operation> {

    private final Operation expected;

    public OperationMatcher(Operation expected){
        this.expected = expected;
    }

    @Override
    //Operation dates are considered to be identical if there is less the 1 second difference between them
    public boolean matches(Operation actual) {
        return expected.getAmount().equals(actual.getAmount()) &&
                expected.getAccountId() == actual.getAccountId() &&
                sameDate(actual.getDate(), expected.getDate(), 1000) &&
                expected.getOperationType().equals(actual.getOperationType());
    }


    private boolean sameDate(Date expected, Date actual, int precision){
        final long expectedTime = expected.getTime();
        final long actualTime = actual.getTime();
        return Math.abs(expectedTime - actualTime) < precision;
    }
}
