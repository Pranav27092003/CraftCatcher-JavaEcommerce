package com.DAO;

import com.entity.Cart;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CartDAOImpl implements CartDAO{

	private Connection conn;
	
	public CartDAOImpl(Connection conn) {
		
		this.conn = conn;
		
	}
	@Override
	public boolean addCart(Cart c) {
		boolean f = false;
		try {
			String sql ="insert into cart(iid,uid,itemname,price,totalprice) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getIid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getItemName());
			ps.setDouble(4, c.getPrice());
			ps.setDouble(5, c.getTotalprice());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	@Override
	public List<Cart> getItemByUser(int userId) {
		List<Cart> list= new ArrayList<>();
		Cart c =null;
		double totalPrice =0;
		try {
			String sql = "select * from cart where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c = new Cart();
				c.setCid(rs.getInt(1));
				c.setIid(rs.getInt(2));
				c.setUid(rs.getInt(3));
				c.setItemName(rs.getString(4));
				c.setPrice(rs.getDouble(5));
				totalPrice = totalPrice+rs.getDouble(6);
				c.setTotalprice(totalPrice);
				
				list.add(c);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public boolean deleteItem(int iid, int uid, int cid) {
		boolean f = false;
		try {
			String sql = "delete from cart where iid = ? and uid =? and cid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	

}
