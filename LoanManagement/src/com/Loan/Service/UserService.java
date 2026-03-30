package com.Loan.Service;



import com.Loan.Enitity.User;

public interface UserService {

	void register(User user);
    User login(String username, String password);
    User getUserById(int id);
}
