package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import com.DAO.ItemDAOImpl;
import com.DB.DBConnect;
import com.entity.ItemDtls;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/editItems")
public class EditItemsServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try { 
			    int id = Integer.parseInt(req.getParameter("id"));
			    String itemname = req.getParameter("iname");
	            String category = req.getParameter("category");	          	          
	            String price = req.getParameter("price");
	            
	            
	            ItemDtls i = new ItemDtls();
	            i.setItemId(id);
	            i.setItemname(itemname);
	            i.setCategory(category);
	            i.setPrice(price);
	            
	            ItemDAOImpl dao = new ItemDAOImpl(DBConnect.getConn());
	            boolean f= dao.updateEditItems(i);
	            
               HttpSession session = req.getSession();
	            
	            if(f) {
	            	
	        	    session.setAttribute("succMsg", "Item udpated Successfully");
	            	resp.sendRedirect("admin/all_items.jsp");
	            }else {
	            	session.setAttribute("failedMsg", "Error in server");
	            	resp.sendRedirect("admin/edit_items.jsp");
	            }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
