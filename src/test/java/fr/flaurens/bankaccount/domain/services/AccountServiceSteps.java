package fr.flaurens.bankaccount.domain.services;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.flaurens.bankaccount.domain.adapters.AccountDAO;
import fr.flaurens.bankaccount.domain.adapters.OperationDAO;
import fr.flaurens.bankaccount.domain.model.Account;
import fr.flaurens.bankaccount.domain.model.Operation;
import fr.flaurens.bankaccount.domain.model.OperationType;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import util.OperationMatcher;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration
@SpringBootTest
public class AccountServiceSteps {

    @Mock
    private AccountDAO accountDAOMock;

    @Mock
    private OperationDAO operationDAOMock;

    @InjectMocks
    private AccountService accountService;

    private long accountId;

    private List<Operation> operationList;

    private List<Operation> expectedOperationList;

    private Date startingTime;

    public AccountServiceSteps(){

    }

    @Before(order=1)
    public void prepareMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Before(order=2)
    public void initializeTimeReference(){
        this.startingTime = Date.from(Instant.now());
    }

    @Given("^I am a bank client$")
    public void i_am_a_bank_client() throws Throwable {
        this.accountId=100;
        this.expectedOperationList = new ArrayList<>();
    }

    @Given("^my account balance is at €(\\d+.\\d+)$")
    public void my_account_balance_is_at_€(double amount) throws Throwable {
        Account account = new Account(accountId);
        account.updateBalance(amount);
        when(accountDAOMock.getAccountById(accountId)).thenReturn(account);
    }

    @When("^I make a deposit of €(\\d+.\\d+) to my account$")
    public void i_make_a_deposit_of_€_to_my_account(double amount) throws Throwable {
        accountService.makeDepositOnAccount(accountId, amount);
        Operation expected = new Operation(accountId,amount,OperationType.DEPOSIT);
        this.expectedOperationList.add(expected);
        verify(operationDAOMock, times(1)).persistOperation(argThat(new OperationMatcher(expected)));
    }

    @Then("^the new balance of my account is €(\\d+.\\d+)$")
    public void the_new_balance_of_my_account_is_€(double amount) throws Throwable {
        assertEquals(amount, accountService.getCurrentBalance(accountId), 0.001);
    }

    @When("^I ask to see the history \\(operation, date, amount, balance\\) of my operations$")
    public void i_ask_to_see_the_history_operation_date_amount_balance_of_my_operations() throws Throwable {
        operationList = accountService.getAccountHistory(accountId);
    }

    @When("^I withdraw €(\\d+.\\d+) from my account$")
    public void i_withdraw_€_from_my_account(double amount) throws Throwable {
        accountService.withdrawFromAccount(accountId, amount);
        Operation expected = new Operation(accountId,amount,OperationType.WITHDRAWAL);
        this.expectedOperationList.add(expected);
        verify(operationDAOMock, times(1)).persistOperation(argThat(new OperationMatcher(expected)));
    }

    @Then("^I get a listing of (\\d+) deposit of €(\\d+.\\d+) then (\\d+) withdrawal €(\\d+.\\d+) of today$")
    public void i_get_a_listing_of_deposit_of_€_then_withdrawal_€_of_today(int nbOfDeposits, double amountOfDeposit, int nbOfWithdrawals, double amountOfWithdrawal) throws Throwable {
        when(operationDAOMock.getOperationByAccount(accountId)).thenReturn(this.expectedOperationList);
        operationList = accountService.getAccountHistory(accountId);

        assertEquals("Number of operations",nbOfDeposits+nbOfWithdrawals,operationList.size());
        assertEquals("Deposit amount check",amountOfDeposit,operationList.get(0).getAmount(),0.001);
        assertEquals("Deposit type check", OperationType.DEPOSIT,operationList.get(0).getOperationType());
        assertTrue("Deposit date check",!operationList.get(0).getDate().after(Date.from(Instant.now()))
                                                            && !operationList.get(0).getDate().before(startingTime));
        assertEquals("Withdrawal amount check",amountOfWithdrawal,operationList.get(1).getAmount(),0.001);
        assertEquals("Withdrawal type check",OperationType.WITHDRAWAL,operationList.get(1).getOperationType());
        assertTrue("Withdrawal date check",!operationList.get(1).getDate().after(Date.from(Instant.now()))
                        && !operationList.get(1).getDate().before(startingTime));
        assertTrue("Date order check",!operationList.get(0).getDate().after(operationList.get(1).getDate()));
    }

}
