package com.user.servlet;

import java.io.IOException;

import com.DAO.CartDAOImpl;
import com.DAO.ItemDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.ItemDtls;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int iid = Integer.parseInt(req.getParameter("iid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			
			ItemDAOImpl dao = new ItemDAOImpl(DBConnect.getConn());
			ItemDtls i = dao.getItemById(iid);
			
			Cart c = new Cart();
			c.setIid(iid);
			c.setUid(uid);
			c.setItemName(i.getItemname());
			c.setPrice(Double.parseDouble(i.getPrice()));
			c.setTotalprice(Double.parseDouble(i.getPrice()));
			
			CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getConn());
			boolean f = dao2.addCart(c);
			
			HttpSession session = req.getSession();
			
			if(f) {
				session.setAttribute("addcart","Item Added to Cart");
				resp.sendRedirect("index.jsp");
			}else {
				session.setAttribute("failed","Some error in server");
				resp.sendRedirect("index.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
