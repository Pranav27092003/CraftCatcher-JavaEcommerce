package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDaoImpl1 implements UserDao1{

	private Connection conn;
	   
	   public UserDaoImpl1(Connection conn) {
		   super();
		   this.conn =conn;
	   }

	   @Override
		public boolean userRegister(User i) {
			boolean f = false;
			
			try {
				
				String sql = "insert into user1(name,email,phno,password) values(?,?,?,?)";
				  PreparedStatement ps= conn.prepareStatement(sql);
				  ps.setString(1, i.getName());
				  ps.setString(2, i.getEmail());
				  ps.setString(3, i.getPhno());
				  ps.setString(4, i.getPassword());				
		
				  int p = ps.executeUpdate();
				
			     if(p==1) {
			    	f= true;
			    }
			  
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return f;
		}

	   @Override
	   public User login(String email, String password) {
	 	  User us = null;
	 	  
	 	  try {
	 		  String sql = "select * from user1 where email = ? and password = ?";
	 		  
	 		  PreparedStatement ps = conn.prepareStatement(sql);
	 		  ps.setString(1, email);
	 		  ps.setString(2, password);
	 		  
	 		  ResultSet res = ps.executeQuery();
	 		  while(res.next()) {
	 			  us = new User();
	 			  us.setId(res.getInt(1));
	 			  us.setName(res.getString(2));
	 			  us.setEmail(res.getString(3));
	 			  us.setPhno(res.getString(4));
	 			  us.setPassword(res.getString(5));
	 			  us.setAddress(res.getString(6));
	 			  us.setLandmark(res.getString(7));
	 			  us.setCity(res.getString(8));
	 			  us.setState(res.getString(9));
	 			  us.setPincode(res.getString(10));
	 			  
	 			  
	 		  }
	 	  }catch(Exception e) {
	 		  e.printStackTrace();
	 	  }
	 	  
	 	  return us;
	 	  
	   }

	@Override
	public boolean checkPassword(int id, String ps) {
		boolean f = false;
		try {
			String sql = "select * from user1 where uid = ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			pst.setString(2, ps);
			
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				f =true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}

	@Override
	public boolean updateprofile(User us) {
		boolean f = false;
		
		try {
			
			String sql = "update user1 set name=?,email=?,phno=? WHERE uid = ?";
			  PreparedStatement ps= conn.prepareStatement(sql);
			  ps.setString(1, us.getName());
			  ps.setString(2, us.getEmail());
			  ps.setString(3, us.getPhno());
			  ps.setInt(4, us.getId());			
	
			  int p = ps.executeUpdate();
			
		     if(p==1) {
		    	f= true;
		    }
		  
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean checkUser(String email) {
        boolean f = true;
		
		try {
			
			String sql = "select * from user1 where email=?";
			  PreparedStatement ps= conn.prepareStatement(sql);
			  
			  ps.setString(1, email);	
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()) {
				  f = false;
			  }
			  
			
		     
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}  	
	
	
	
	  
}
	