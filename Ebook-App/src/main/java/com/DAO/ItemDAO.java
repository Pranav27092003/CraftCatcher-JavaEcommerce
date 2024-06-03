package com.DAO;

import com.entity.ItemDtls;
import java.util.List;
public interface ItemDAO {
	
		public boolean addItems(ItemDtls i); //  method 1: add items
		
		public List<ItemDtls> getAllItems(); // method 2: displaying all items
		
		public ItemDtls getItemById(int id);       // method 3: getting item to edit table
		
		public boolean updateEditItems(ItemDtls i);   // method 4: updating items data
		
		public boolean  deleteItems(int id);      // method 5 : delete items
		
		public List<ItemDtls> getResinProduct();  // method 6: to show resin items on our home page 
		
		public List<ItemDtls> getDreamCatchers(); // method 7: to show dreamcatchers on our home page
		
		public List<ItemDtls>  getHandicraftItems(); // method 8: to get handicraft items on our page
		
		public List<ItemDtls> allDreamcatchers();   // method 9: to get all dreamcatchers on view page
		
		public List<ItemDtls> allResinProducts();   // method 10: to get all resin products on view page
		
		public List<ItemDtls> allHandicrafts();   // method 11:  to get all handicraft items on view page
		
		public List<ItemDtls> getItemBySearch(String ch);    // method 12: to search item by its name
		
		
}
