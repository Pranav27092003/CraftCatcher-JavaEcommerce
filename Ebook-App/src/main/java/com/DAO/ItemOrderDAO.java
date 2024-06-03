package com.DAO;

import java.util.List;

import com.entity.ItemOrder;

public interface ItemOrderDAO {
		
	public boolean saveOrder( List<ItemOrder> ilist);
	
	public List<ItemOrder> getItem(String email);
	
	public List<ItemOrder> getAllOrder();
	
	
}
