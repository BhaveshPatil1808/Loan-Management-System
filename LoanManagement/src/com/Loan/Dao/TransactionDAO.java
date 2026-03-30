package com.Loan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Loan.DB.DBConnection;
import com.Loan.Enitity.Transaction;

public class TransactionDAO {

	/*
	 * public boolean addTransaction(Transaction txn);
	 * 
	 * public List<Transaction> getTransactionsByLoanId(int loanId);
	 */

	public List<Transaction> getTransactionsByLoanId(int loanId){
		List<Transaction> list = new ArrayList<Transaction>();
		try(Connection con = DBConnection.getConnection()){
			String quey = "SELECT * FROM transactions WHERE loan_id = ?;";
			PreparedStatement ps = con.prepareStatement(quey);
			ps.setInt(1, loanId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Transaction(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4)));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addTransaction(Transaction txn) {
		try(Connection con = DBConnection.getConnection()){
			String query = "INSERT INTO transactions VALUES (?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setInt(2, txn.getLoanId());
			ps.setDouble(3, txn.getAmount());
			ps.setDate(4, txn.getDate());
			
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Transaction added..");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
