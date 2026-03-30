package com.Loan.Service;

import java.util.List;

import com.Loan.Enitity.LoanApplication;

public interface LoanService {

	void applyLoan(LoanApplication loan);

    List<LoanApplication> getUserLoans(int userId);

    List<LoanApplication> getAppliedLoans(); // for agent

    boolean approveLoan(int loanId);

    void rejectLoan(int loanId);

    List<LoanApplication> getAllLoans(); // admin
}
