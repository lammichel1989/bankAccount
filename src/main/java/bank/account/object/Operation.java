package bank.account.object;

public enum Operation {
	DEPOSIT("Deposit"), WITHDRAWAL("Withdrawal");
	
	public final String label;

    private Operation(String label) {
        this.label = label;
    }
}