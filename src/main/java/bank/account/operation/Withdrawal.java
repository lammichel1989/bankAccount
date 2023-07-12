package bank.account.operation;

import java.util.Date;

import bank.account.object.Account;
import bank.account.object.Operation;
import bank.account.operation.exception.OperationException;

public class Withdrawal implements AccountOperation {

	@Override
	public void execute(Account account, Float amount) throws OperationException {
		if(amount > 0) {
			account.setBalance(account.getBalance() - amount);
			account.registerStatement(new Date(), amount, account.getBalance(), Operation.WITHDRAWAL.label);
		} else {
			throw new OperationException("cannot withdraw a negative amount");
		}
	}



}
