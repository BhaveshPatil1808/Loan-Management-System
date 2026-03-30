package com.Loan.Enitity;

public class LoanApplication {

	private int id;
	private int userId;
	private double amount;
	private int duration;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LoanApplication(int id, int userId, double amount, int duration, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.amount = amount;
		this.duration = duration;
		this.status = status;
	}
	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void displayForCustomer() {
        System.out.println("ID: " + id +
                " Amount: " + amount +
                " Duration: " + duration +
                " Status: " + status);
    }

    // 🧑‍💼 Agent/Admin View
    public void displayFull() {
        System.out.println("ID: " + id +
                " User: " + userId +
                " Amount: " + amount +
                " Duration: " + duration +
                " Status: " + status);
    }
	
}
