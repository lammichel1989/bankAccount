package bank.account.operation;

import bank.account.object.Account;
import bank.account.operation.exception.OperationException;

public interface AccountOperation {

	public void execute(Account account, Float amount) throws OperationException;
	
}
