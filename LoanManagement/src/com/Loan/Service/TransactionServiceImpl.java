package com.Loan.Service;

import java.util.List;

import com.Loan.Dao.TransactionDAO;
import com.Loan.Enitity.Transaction;

public class TransactionServiceImpl implements TransactionService {

	private TransactionDAO transactionDAO = new TransactionDAO();
	@Override
	public void payEMI(Transaction txn) {
		// TODO Auto-generated method stub
		transactionDAO.addTransaction(txn);
	}

	@Override
	public List<Transaction> getTransactions(int loanId) {
		// TODO Auto-generated method stub
		return transactionDAO.getTransactionsByLoanId(loanId);
	}

}
