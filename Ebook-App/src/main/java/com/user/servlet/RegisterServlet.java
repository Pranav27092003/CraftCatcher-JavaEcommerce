package com.user.servlet;
import java.io.IOException;
import com.DAO.UserDaoImpl1;
import com.DB.DBConnect;
import com.entity.User;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;



@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		try {
			
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");
			String check = req.getParameter("check");
			
			
			User us = new User(name, email, phno, password);
		    
		   
		    
			HttpSession session = req.getSession();
			
			
			if(check!= null) {
				UserDaoImpl1 dao = new UserDaoImpl1(DBConnect.getConn());
				boolean f2 = dao.checkUser(email);
				
				if(f2) {
					boolean f = dao.userRegister(us);
					
					if(f) {
						session.setAttribute("succMsg","Registered Successfully...");
						resp.sendRedirect("register.jsp");
					}else {
						session.setAttribute("failMsg","Some error in server");
						resp.sendRedirect("register.jsp");
					}
				}else {
					session.setAttribute("failMsg","User Already exist, Try with other email");
					resp.sendRedirect("register.jsp");
				}
			}else {
				session.setAttribute("failMsg","Please check agree and terms condititons ");
				resp.sendRedirect("register.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/register.jsp").forward(req, resp);;
	}
	
	
	
}