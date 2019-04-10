package fr.flaurens.bankaccount.domain.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.model.FrameworkMethod;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AmountTest {

    @Parameter
    public Double amountValue;

    @Parameter(1)
    public Class<? extends Exception> expectedException;

    @Parameter(2)
    public String expectedExceptionCode;

    @Parameter(3)
    public String label;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameters(name="{index}: {3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { null, InvalidAmountException.class, "Amount is NULL", "Amounts can't be NULL"},
                { 0d, InvalidAmountException.class, "Amount is 0", "Amounts can't be equal to 0" },
                { -1d, InvalidAmountException.class, "Amount is negative: -1.0", "Amounts can't be negative"},
                { 1d, null, null, "Amounts can be positive"},
        });

    }

    @Test
    public void amountCreationTest() throws InvalidAmountException {



        if (expectedException != null) {
            thrown.expect(expectedException);
            thrown.expectMessage(expectedExceptionCode);
        }

        Amount amount = new Amount(amountValue);

        assertEquals("created amount is correct", amountValue, amount.getAmountValue());
    }
}

