package bank.account.operation;

/**
 *  This class create the available operations
 */
public class AccountOperationFactory {
	
	public AccountOperation createDeposit() {
		return new Deposit();
	}
	
	public AccountOperation createWithdrawal() {
		return new Withdrawal();
	}

}
