package com.Loan.Service;

import com.Loan.Dao.UserDao;
import com.Loan.Enitity.User;

public class UserServiceImpl implements UserService {

	private UserDao dao = new UserDao();
	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		dao.registerUser(user);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username, password);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return dao.getUserById(id);
	}

}
