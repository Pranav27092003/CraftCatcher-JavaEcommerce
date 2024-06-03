package com.DAO;

import java.sql.*;
import java.util.*;
import com.entity.ItemDtls;

public class ItemDAOImpl implements ItemDAO{
	
	private Connection conn;
	
	public ItemDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	@Override
	public boolean addItems(ItemDtls i) {
		boolean f = false;
		
		try {
			String sql ="insert into item_details(itemname,category,user_email,itemphoto,itemprice) values(?,?,?,?,?)";		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, i.getItemname());
			ps.setString(2, i.getCategory());
			ps.setString(3, i.getUser_email());
			ps.setString(4, i.getItemphoto());
			ps.setString(5, i.getPrice());
			
		    int p=	ps.executeUpdate();
		    if(p==1) {
		    	f= true;
		    }
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<ItemDtls> getAllItems() {
		List<ItemDtls> list = new ArrayList<>();
		ItemDtls i = null;
		
		try {			
			String sql = "Select * from item_details";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i = new ItemDtls();
				i.setItemId(rs.getInt(1));
				i.setItemname(rs.getString(2));
				i.setCategory(rs.getString(3));
				i.setUser_email(rs.getString(4));
				i.setItemphoto(rs.getString(5));
				i.setPrice(rs.getString(6));
				list.add(i);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ItemDtls getItemById(int id) {
		
		ItemDtls i = null;
		try {
			String sql = "select * from item_details where itemId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i = new ItemDtls();
				i.setItemId(rs.getInt(1));
				i.setItemname(rs.getString(2));
				i.setCategory(rs.getString(3));
				i.setUser_email(rs.getString(4));
				i.setItemphoto(rs.getString(5));
				i.setPrice(rs.getString(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public boolean updateEditItems(ItemDtls i) {
		boolean f =false;
		try {
			String sql = "update item_details set itemname=?,  category=?, itemprice=? where itemId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i.getItemname());
			ps.setString(2, i.getCategory());
			ps.setString(3, i.getPrice());
			ps.setInt(4, i.getItemId());
			
			
			int p= ps.executeUpdate();
			if(p==1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}

	@Override
	public boolean deleteItems(int id) {
		boolean f = false;
		
		try {
			String sql = "delete from item_details where itemId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);			
		    ps.setInt(1, id);
		    int  i=ps.executeUpdate();
		    if(i==1) {
		    	f =true;
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}

	@Override
	public List<ItemDtls> getResinProduct() {
		List<ItemDtls> list = new ArrayList<ItemDtls>();
		ItemDtls i = null;
		try {
			String sql = "select * from item_details where category=? order by itemId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Resin Product");
			ResultSet rs= ps.executeQuery();
			int x=1;
			while(rs.next() && x<=4) {
				i = new ItemDtls();
				i.setItemId(rs.getInt(1));
				i.setItemname(rs.getString(2));
				i.setCategory(rs.getString(3));
				i.setUser_email(rs.getString(4));
				i.setItemphoto(rs.getString(5));
				i.setPrice(rs.getString(6));
				list.add(i);
				x++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ItemDtls> getDreamCatchers() {
		List<ItemDtls> list = new ArrayList<ItemDtls>();
		ItemDtls i = null;
		try {
			String sql = "select * from item_details where category=? order by itemId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Dreamcatchers");
			ResultSet rs= ps.executeQuery();
			int x=1;
			while(rs.next() && x<=4) {
				i = new ItemDtls();
				i.setItemId(rs.getInt(1));
				i.setItemname(rs.getString(2));
				i.setCategory(rs.getString(3));
				i.setUser_email(rs.getString(4));
				i.setItemphoto(rs.getString(5));
				i.setPrice(rs.getString(6));
				list.add(i);
				x++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ItemDtls> getHandicraftItems() {
		List<ItemDtls> list = new ArrayList<ItemDtls>();
		ItemDtls i = null;
		try {
			String sql = "select * from item_details where category=? order by itemId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Handicraft Item");
			ResultSet rs= ps.executeQuery();
			int x=1;
			while(rs.next() && x<=4) {
				i = new ItemDtls();
				i.setItemId(rs.getInt(1));
				i.setItemname(rs.getString(2));
				i.setCategory(rs.getString(3));
				i.setUser_email(rs.getString(4));
				i.setItemphoto(rs.getString(5));
				i.setPrice(rs.getString(6));
				list.add(i);
				x++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ItemDtls> allDreamcatchers() {
		List<ItemDtls> list = new ArrayList<ItemDtls>();
		ItemDtls i = null;
		try {
			String sql = "select * from item_details where category=? order by itemId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Dreamcatchers");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				i = new ItemDtls();
				i.setItemId(rs.getInt(1));
				i.setItemname(rs.getString(2));
				i.setCategory(rs.getString(3));
				i.setUser_email(rs.getString(4));
				i.setItemphoto(rs.getString(5));
				i.setPrice(rs.getString(6));
				list.add(i);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ItemDtls> allResinProducts() {
		List<ItemDtls> list = new ArrayList<ItemDtls>();
		ItemDtls i = null;
		try {
			String sql = "select * from item_details where category=? order by itemId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Resin Product");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				i = new ItemDtls();
				i.setItemId(rs.getInt(1));
				i.setItemname(rs.getString(2));
				i.setCategory(rs.getString(3));
				i.setUser_email(rs.getString(4));
				i.setItemphoto(rs.getString(5));
				i.setPrice(rs.getString(6));
				list.add(i);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ItemDtls> allHandicrafts() {
		List<ItemDtls> list = new ArrayList<ItemDtls>();
		ItemDtls i = null;
		try {
			String sql = "select * from item_details where category=? order by itemId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Handicraft Item");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				i = new ItemDtls();
				i.setItemId(rs.getInt(1));
				i.setItemname(rs.getString(2));
				i.setCategory(rs.getString(3));
				i.setUser_email(rs.getString(4));
				i.setItemphoto(rs.getString(5));
				i.setPrice(rs.getString(6));
				list.add(i);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ItemDtls> getItemBySearch(String ch) {
		List<ItemDtls> list = new ArrayList<>();
		ItemDtls i = null;
		
		try {
			String sql = "select * from item_details where itemname like ? or category like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				i = new ItemDtls();
				i.setItemId(rs.getInt(1));
				i.setItemname(rs.getString(2));
				i.setCategory(rs.getString(3));
				i.setUser_email(rs.getString(4));
				i.setItemphoto(rs.getString(5));
				i.setPrice(rs.getString(6));
				list.add(i);
				
			}}catch(Exception e) {
				e.printStackTrace();
			}
		
		return list;
	}
	
	
    
	
	
	
}
