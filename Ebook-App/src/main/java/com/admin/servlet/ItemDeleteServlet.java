package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import com.DAO.ItemDAOImpl;
import com.DB.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class ItemDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  try {
		  int id = Integer.parseInt(req.getParameter("id"));  
		  ItemDAOImpl dao = new ItemDAOImpl(DBConnect.getConn());       
          
          
          boolean f = dao.deleteItems(id);
          
          HttpSession session = req.getSession();
          
          if(f) {
          
          	session.setAttribute("succMsg", "Item Added Successfully");
          	resp.sendRedirect("admin/all_items.jsp");
          }else {
          	session.setAttribute("failedMsg", "Error in server");
          	resp.sendRedirect("admin/all_items.jsp");
          }
		  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	}
	

}
