package bank.account.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bank.account.object.Account;
import bank.account.object.Client;
import bank.account.operation.AccountOperation;
import bank.account.operation.AccountOperationFactory;
import bank.account.operation.exception.OperationException;

public class AccountOperationTest {
	
	private Account clientAccount;
	private AccountOperation deposit;
	private AccountOperation withdraw;
	
	public Account getClientAccount() {
		return clientAccount;
	}

	public void setClientAccount(Account clientAccount) {
		this.clientAccount = clientAccount;
	}

	public AccountOperation getDeposit() {
		return deposit;
	}

	public void setDeposit(AccountOperation deposit) {
		this.deposit = deposit;
	}

	public AccountOperation getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(AccountOperation withdraw) {
		this.withdraw = withdraw;
	}

	@BeforeEach
	public void setUp() {
		AccountOperationFactory accountOperationFactory = new AccountOperationFactory();
		deposit = accountOperationFactory.createDeposit();
		withdraw = accountOperationFactory.createWithdrawal();
		
		Client client = new Client(1234, "Michel", "LAM");
		this.clientAccount = client.getAccount();
	}
	
    @Test
    public void deposit_amounts_to_an_account() throws OperationException {
		deposit.execute(clientAccount, 1000f);
		assertEquals(clientAccount.getBalance(), 1000f);
		assertEquals(clientAccount.getStatements().size(), 1);
		
		deposit.execute(clientAccount, 200f);
		assertEquals(clientAccount.getBalance(), 1200f);
		assertEquals(clientAccount.getStatements().size(), 2);
    }
    
    @Test
    public void withdraw_amounts_to_an_account() throws OperationException {
		deposit.execute(clientAccount, 1000f);
		assertEquals(clientAccount.getBalance(), 1000f);
		assertEquals(clientAccount.getStatements().size(), 1);
		
		withdraw.execute(clientAccount, 200f);
		assertEquals(clientAccount.getBalance(), 800f);
		assertEquals(clientAccount.getStatements().size(), 2);
    }
    
    @Test
    public void deposit_negative_amount_to_an_account() throws OperationException {
        Exception exception = assertThrows(OperationException.class, () -> {
        	deposit.execute(clientAccount, -100f);
        });
        
        String expectedMessage = "cannot deposit a negative amount";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
    
    @Test
    public void withdraw_negative_amount_to_an_account() throws OperationException {
        Exception exception = assertThrows(OperationException.class, () -> {
        	withdraw.execute(clientAccount, -100f);
        });
        
        String expectedMessage = "cannot withdraw a negative amount";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
    

}
