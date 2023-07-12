package bank.account.display;

import bank.account.object.Account;
import bank.account.object.Client;
import bank.account.operation.AccountOperation;
import bank.account.operation.AccountOperationFactory;
import bank.account.operation.exception.OperationException;

/**
 *  Display the operations of a client's bank account.
 */
public class Display {
	
	public static void main(String[] args) {
		
		AccountOperationFactory accountOperationFactory = new AccountOperationFactory();
		AccountOperation deposit = accountOperationFactory.createDeposit();
		AccountOperation withdraw = accountOperationFactory.createWithdrawal();
		
		System.out.println("Create an account");
		Client client = new Client(1234, "Michel", "LAM");
		Account clientAccount = client.getAccount();
		try {
			deposit.execute(clientAccount, 1000f);
			withdraw.execute(clientAccount, 259.4f);
			withdraw.execute(clientAccount, 138.4f);
			clientAccount.displayStatements();
		} catch (OperationException e) {
			System.out.println(e.getMessage());
		}
	}

}
