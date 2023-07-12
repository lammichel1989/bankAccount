package bank.account.object;

import java.util.Date;

public class Statement {
	
	private Date date;
	private Float amount;
	private Float balance;
	private String operation;
	
	public Statement(Date date, Float amount, Float balance, String operation) {
		this.date = date;
		this.amount = amount;
		this.balance = balance;
		this.operation = operation;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

}
