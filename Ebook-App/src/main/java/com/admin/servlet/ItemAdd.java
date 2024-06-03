package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import com.DAO.ItemDAOImpl;
import com.DB.DBConnect;
import com.entity.ItemDtls;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@WebServlet("/add_item")
@MultipartConfig
public class ItemAdd extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
	            String itemname = req.getParameter("iname");
	            String category = req.getParameter("category");	          	          
	            String price = req.getParameter("price");
	            Part part = req.getPart("iimg");
	            String filename =part.getSubmittedFileName();
	            
	            ItemDtls i = new ItemDtls(itemname, category,"admin",filename,price );
	            
	            ItemDAOImpl dao = new ItemDAOImpl(DBConnect.getConn());
	            
	           
	            
	            boolean f = dao.addItems(i);
	            
	            HttpSession session = req.getSession();
	            
	            if(f) {
	            	
	            	 String path = getServletContext().getRealPath("")+"images";	  	           
	 	             File file = new File(path);
	 	             part.write(path+File.separator+filename);
	 	            
	            	session.setAttribute("succMsg", "Item Added Successfully");
	            	resp.sendRedirect("admin/add_item.jsp");
	            }else {
	            	session.setAttribute("failedMsg", "Error in server");
	            	resp.sendRedirect("admin/add_item.jsp");
	            }
			}catch(Exception e) {
				e.printStackTrace();
			}
	
	
	}
}
