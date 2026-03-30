package com.Loan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Loan.DB.DBConnection;
import com.Loan.Enitity.LoanApplication;

public class LoanDao {
	/*
	 * public boolean applyLoan(LoanApplication loan);
	 * public List<LoanApplication> getLoansByUserId(int userId);
		public List<LoanApplication> getLoansByStatus(String status);
		public List<LoanApplication> getAllLoans();
		public boolean updateLoanStatus(int loanId, String status);
	 */
	public LoanApplication getLoanById(int loanId) {
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM loan_applications WHERE ID = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return mapApp(rs);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateLoanStatus(int loanId, String status) {
		try(Connection con = DBConnection.getConnection()){
			String query = "UPDATE loan_applications SET status = ? WHERE id=?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, status);
			ps.setInt(2, loanId);
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<LoanApplication> getAllLoans(){
		List<LoanApplication> list = new ArrayList<LoanApplication>();
		
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM loan_applications;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(mapApp(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<LoanApplication> getLoansByStatus(String status){
		List<LoanApplication> list = new ArrayList<LoanApplication>();
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM loan_applications WHERE status = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(mapApp(rs));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<LoanApplication> getLoansByUserId(int userId){
		List<LoanApplication> list = new ArrayList<LoanApplication>();
		
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM loan_applications WHERE user_id = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(mapApp(rs));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return list;
		}
	}
	
	public void applyLoan(LoanApplication loan) {
		try(Connection con = DBConnection.getConnection()){
			String query = "INSERT INTO loan_applications VALUES(?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setInt(2, loan.getUserId());
			ps.setDouble(3,loan.getAmount());
			ps.setInt(4,loan.getDuration());
			ps.setString(5,loan.getStatus());
			
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Application Submitted..");
			}else {
				System.out.println("Something went Wrong..");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private LoanApplication mapApp(ResultSet rs) {
		try {
			return new LoanApplication(rs.getInt("id"), rs.getInt("user_id"), rs.getDouble("amount"), rs.getInt("duration"), rs.getString("status"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
