package bank.account.operation;

import java.util.Date;

import bank.account.object.Account;
import bank.account.object.Operation;
import bank.account.operation.exception.OperationException;

public class Deposit implements AccountOperation {

	@Override
	public void execute(Account account, Float amount) throws OperationException {
		if(amount > 0) {
			account.setBalance(account.getBalance() + amount);
			account.registerStatement(new Date(), amount, account.getBalance(), Operation.DEPOSIT.label);
		} else {
			throw new OperationException("cannot deposit a negative amount");
		}
	}

}
