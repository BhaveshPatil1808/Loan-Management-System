package com.Loan.Service;

import java.util.List;

import com.Loan.Dao.LoanDao;
import com.Loan.Dao.LoanDetailsDao;
import com.Loan.Enitity.LoanApplication;
import com.Loan.Enitity.LoanDetails;

public class LoanServiceImpl implements LoanService {

	private LoanDao loanDao = new LoanDao();
	private LoanDetailsDao loanDetailsDao = new LoanDetailsDao();
	private EMIService emiService  = new EMIService();
	@Override
	public void applyLoan(LoanApplication loan) {
		// TODO Auto-generated method stub
		loan.setStatus("APPLIED");
		loanDao.applyLoan(loan);
	}

	@Override
	public List<LoanApplication> getUserLoans(int userId) {
		// TODO Auto-generated method stub
		return loanDao.getLoansByUserId(userId);
	}

	@Override
	public List<LoanApplication> getAppliedLoans() {
		// TODO Auto-generated method stub
		return loanDao.getLoansByStatus("APPLIED");
	}

	@Override
	public boolean approveLoan(int loanId) {
		boolean update = loanDao.updateLoanStatus(loanId, "APPROVED");
		if(update) {
			LoanApplication loan = loanDao.getLoanById(loanId);
			double rate = 10;
			double emi = emiService.calculateEMI(loan.getAmount(), rate, loan.getDuration());
			LoanDetails details = new LoanDetails(
                    0, loanId, rate, emi
            );
			
			loanDetailsDao.addLoanDetails(details);
		}
		return update;
	}

	@Override
	public void rejectLoan(int loanId) {
		// TODO Auto-generated method stub
		loanDao.updateLoanStatus(loanId, "REJECT");
	}

	@Override
	public List<LoanApplication> getAllLoans() {
		// TODO Auto-generated method stub
		return loanDao.getAllLoans();
	}

}
