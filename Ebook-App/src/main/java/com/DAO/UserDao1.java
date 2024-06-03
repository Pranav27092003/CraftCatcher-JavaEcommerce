package com.DAO;

import com.entity.User;

public interface UserDao1 {
	
	
	public boolean userRegister(User us);	                // Method 1 to register user
	
	public User login(String email,String pasword);         // Method 2 to login user
	
	public boolean checkPassword( int id, String ps);       // Method 3 to verify user password
	
	public boolean updateprofile(User us);					// Method 4 to update the user password
	
	public boolean checkUser(String email);                 // Method  5 to ensure validity of only one user with the email-id
}
