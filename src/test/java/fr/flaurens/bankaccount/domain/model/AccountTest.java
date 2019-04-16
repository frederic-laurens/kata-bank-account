package fr.flaurens.bankaccount.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    @Test
    public void newAccountBalanceShouldBeSetTo0(){
        Account account = new Account(5668L);
        assertEquals("account should be created with a balance equal to 0", 0d, account.getBalance(), 0.001);
    }

    @Test
    public void balanceUpdateDeposit(){
        Account account = new Account(5668L);
        account.updateBalance(10);
        assertEquals("account balance should be updated positively",10, account.getBalance(), 0.001);
        assertFalse("account balance should be positive", account.overdraft());
    }

    @Test
    public void balanceUpdateWithdrawal(){
        Account account = new Account(5668L);
        account.updateBalance(-10);
        assertEquals("account balance should be updated negatively",-10, account.getBalance(), 0.001);
        assertTrue("account balance should be negative", account.overdraft());
    }
}
