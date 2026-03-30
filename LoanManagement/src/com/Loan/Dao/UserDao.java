package com.Loan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Loan.DB.DBConnection;
import com.Loan.Enitity.User;

public class UserDao {
	/*
	public boolean registerUser(User user);
	public User login(String username, String password);
	public List<User> getAllUsers(); // optional
	public User getUserById(int id);

	*/
	public User getUserById(int id) {
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM users WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
				return user;
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<User> getAllUsers(){
		List<User> list = new ArrayList<>();
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM users";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				list.add(new User(rs.getInt("id"), 
						rs.getString("username"), 
						rs.getString("password"), 
						rs.getString("role")));
				
			}
			
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return list;
		}
	}
	public User login(String username, String password) {
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM users WHERE username = ? AND password = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
				return user;
			}else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void registerUser(User user) {
		try(Connection con = DBConnection.getConnection()){
			String query = "INSERT INTO users VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("User Registered..");
			}else {
				System.out.println("Something is wrong..");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
