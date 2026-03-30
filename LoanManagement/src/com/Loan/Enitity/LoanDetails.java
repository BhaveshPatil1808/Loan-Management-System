package com.Loan.Enitity;

public class LoanDetails {
	
	private int loanId;
	private int applicationId;
	private double intrestRate;
	private double emi;
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public double getIntrestRate() {
		return intrestRate;
	}
	public void setIntrestRate(double intrestRate) {
		this.intrestRate = intrestRate;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public LoanDetails(int loanId, int applicationId, double intrestRate, double emi) {
		super();
		this.loanId = loanId;
		this.applicationId = applicationId;
		this.intrestRate = intrestRate;
		this.emi = emi;
	}
	public LoanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
