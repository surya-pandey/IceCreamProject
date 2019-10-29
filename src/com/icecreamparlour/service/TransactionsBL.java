package com.icecreamparlour.service;

import com.icecreamparlour.entities.Transactions;

public interface TransactionsBL {
	public void insertNewTransactionDetailsBL(Transactions transactions);
	public Transactions viewAllTransactionsBL();
}
