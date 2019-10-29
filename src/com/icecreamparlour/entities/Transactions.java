package com.icecreamparlour.entities;

public class Transactions {
	
	private int transactionId;
	
	public Transactions() {
		
	}

	public Transactions(int transactionId) {
		super();
		this.transactionId = transactionId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + "]";
	}

}
