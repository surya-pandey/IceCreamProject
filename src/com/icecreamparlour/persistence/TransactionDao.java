package com.icecreamparlour.persistence;

import com.icecreamparlour.entities.Transactions;

public interface TransactionDao {
	public void insertNewTransactionDetails(Transactions transactions);
	public Transactions viewAllTransactions();
}
