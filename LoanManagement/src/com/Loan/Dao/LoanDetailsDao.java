package com.Loan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Loan.DB.DBConnection;
import com.Loan.Enitity.LoanDetails;

public class LoanDetailsDao {
	
	/*
	 * public boolean addLoanDetails(LoanDetails details);
	   public LoanDetails getLoanDetailsByApplicationId(int applicationId);
	 */

	public LoanDetails getLoanDetailsByApplicationId(int applicationId) {
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM loan_details WHERE application_id =?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, applicationId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				LoanDetails ld = new LoanDetails(rs.getInt("id"), rs.getInt(2), rs.getDouble(3), rs.getDouble(4));
				return ld;
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void addLoanDetails(LoanDetails details) {
		try(Connection con = DBConnection.getConnection()){
			String query = "INSERT INTO loan_details VALUES (?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setInt(2, details.getApplicationId());
			ps.setDouble(3, details.getIntrestRate());
			ps.setDouble(4, details.getEmi());
			
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Loan Details Added");
			}else {
				System.out.println("Loan details not added");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
