package bank.account.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
	
	public Account() {
		this.balance = 0.0f;
		this.statements = new ArrayList<Statement>();
	}
	
	// The total balance of the account
	private Float balance;
	
	private List<Statement> statements;

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	public void registerStatement(Date date, Float amount, Float balance, String operation) {
		Statement statement = new Statement(date, amount, balance, operation);
		statements.add(statement);
	}
	
	public void displayStatements() {
		statements.stream().map(stm -> "Operation : ".concat(stm.getOperation()) 
				.concat(" ; Date : ").concat(stm.getDate().toString()).concat(" ; Amount : ").concat(stm.getAmount().toString())
				.concat(" ; Balance : ").concat(stm.getBalance().toString()))
		.forEach(System.out::println);
	}

}
