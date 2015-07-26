package com.manning.spock.chapter8.loan;

public class Loan {

	private int amount;
	private long instalments;
	
	private boolean approved = false;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getInstalments() {
		return instalments;
	}

	public void setInstalments(long instalments) {
		this.instalments = instalments;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	
}
