package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.ItemOrder;

public class ItemOrderDAOImpl implements ItemOrderDAO{
	
	private Connection conn;
		
	public ItemOrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	

	@Override
	public boolean saveOrder(List<ItemOrder> ilist) {
		boolean f = false;
		
		try {
			String sql = "insert into itemorder(orderid, username, email,address,phno,itemname,price,payment) values (?,?,?,?,?,?,?,?)";
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			for(ItemOrder i: ilist) {
				ps.setString(1, i.getOrderid());
				ps.setString(2, i.getUsername());
				ps.setString(3, i.getEmail());
				ps.setString(4, i.getFullAddress());
				ps.setString(5, i.getPhno());
				ps.setString(6, i.getItemname());
				ps.setString(7, i.getPrice());
				ps.setString(8, i.getPaymentType());
				ps.addBatch();
			}
			
			int[] count = ps.executeBatch();
			conn.commit();
			f = true;
			conn.setAutoCommit(true);
			
		}catch(Exception e) {
		    e.printStackTrace();
		}
		
		
		return f;
	}



	@Override
	public List<ItemOrder> getItem(String email) {
		List<ItemOrder> list = new ArrayList<ItemOrder>();
		ItemOrder o = null;
		try {
			String sql = "select * from itemorder where email =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				o= new ItemOrder();
				o.setId(res.getInt(1));
				o.setOrderid(res.getString(2));
				o.setUsername(res.getString(3));
				o.setEmail(res.getString(4));
				o.setFullAddress(res.getString(5));
				o.setPhno(res.getString(6));
				o.setItemname(res.getString(7));
				o.setPrice(res.getString(8));
				o.setPaymentType(res.getString(9));
				list.add(o);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public List<ItemOrder> getAllOrder(){
		List<ItemOrder> list = new ArrayList<ItemOrder>();
		ItemOrder o = null;
		try {
			String sql = "select * from itemorder";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				o= new ItemOrder();
				o.setId(res.getInt(1));
				o.setOrderid(res.getString(2));
				o.setUsername(res.getString(3));
				o.setEmail(res.getString(4));
				o.setFullAddress(res.getString(5));
				o.setPhno(res.getString(6));
				o.setItemname(res.getString(7));
				o.setPrice(res.getString(8));
				o.setPaymentType(res.getString(9));
				list.add(o);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	

	
	
	
	
}
