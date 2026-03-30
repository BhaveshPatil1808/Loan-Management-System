package com.Loan.Service;

import java.util.List;

import com.Loan.Enitity.Transaction;

public interface TransactionService {

	void payEMI(Transaction txn);

    List<Transaction> getTransactions(int loanId);
}
