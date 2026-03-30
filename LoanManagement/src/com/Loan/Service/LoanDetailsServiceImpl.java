package com.Loan.Service;

import com.Loan.Dao.LoanDetailsDao;
import com.Loan.Enitity.LoanDetails;

public class LoanDetailsServiceImpl implements LoanDetailsService {

	private LoanDetailsDao loanDetailsDao = new LoanDetailsDao();
	@Override
	public LoanDetails getLoanDetails(int applicationId) {
		// TODO Auto-generated method stub
		return loanDetailsDao.getLoanDetailsByApplicationId(applicationId);
	}

}
