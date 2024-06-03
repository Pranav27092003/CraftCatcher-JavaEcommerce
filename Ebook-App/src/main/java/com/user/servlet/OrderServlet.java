package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.DAO.CartDAOImpl;
import com.DAO.ItemOrderDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.ItemOrder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session = req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String paymentType = req.getParameter("payment");
			
			String fullAddress = address+","+landmark+","+city+","+state+","+pincode;
			CartDAOImpl dao = new  CartDAOImpl(DBConnect.getConn());
		    List<Cart> ilist =	dao.getItemByUser(id);
		    
		    
		    if(ilist.isEmpty()) {
		    	session.setAttribute("failedMsg","Add Item to Order");
		    	resp.sendRedirect("checkout.jsp");
		    }else {
		    	ItemOrderDAOImpl dao2 = new ItemOrderDAOImpl(DBConnect.getConn());
			    
			    
			    ItemOrder o = null;
			    ArrayList<ItemOrder> orderlist = new ArrayList<ItemOrder>();
			    Random r = new Random();
			    for(Cart c: ilist) {
			    	    o = new ItemOrder();
			    		o.setOrderid("ITEM-ORD-00"+r.nextInt(1000));
			    		o.setUsername(name);
			    		o.setEmail(email);
			    		o.setPhno(phno);
			    		o.setFullAddress(fullAddress);
			    		o.setItemname(c.getItemName());
			    		o.setPrice(c.getPrice()+"");
			    		o.setPaymentType(paymentType);
			    		orderlist.add(o);
			    		
			    }
			    if("noselect".equals(paymentType)) {
			    	session.setAttribute("failedMsg","Please choose payment type");
			    	resp.sendRedirect("checkout.jsp");    
			    }else {
			    	boolean f= dao2.saveOrder(orderlist);
			    	
			    	if(f) {
			    		resp.sendRedirect("orderSuccess.jsp");
			    	}else {
			    		session.setAttribute("failedMsg","Your Order Failed");
				    	resp.sendRedirect("checkout.jsp");    
			    	}
			    }
		    }
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
		
}
