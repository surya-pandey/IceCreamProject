package com.icecreamparlour.service;

import com.icecreamparlour.entities.Transactions;
import com.icecreamparlour.persistence.TransactionDaoImpl;

public class TransactionsBLImpl implements TransactionsBL {
	
	TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
	
	@Override
	public void insertNewTransactionDetailsBL(Transactions transactions) {
		transactionDaoImpl.insertNewTransactionDetails(transactions);
	}

	@Override
	public Transactions viewAllTransactionsBL() {
		transactionDaoImpl.viewAllTransactions();
		return null;
	}
}
