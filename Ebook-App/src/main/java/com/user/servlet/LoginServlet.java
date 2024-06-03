package com.user.servlet;
import java.io.IOException;

import com.DAO.UserDaoImpl1;
import com.DB.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
    try {	
    	
    	UserDaoImpl1 dao = new UserDaoImpl1(DBConnect.getConn());
    	HttpSession session = req.getSession();
    	
			String email = req.getParameter("email");			
			String password = req.getParameter("password");
			
			if("admin@gmail.com".equals(email)&& "admin".equals(password)) {
				User us = new User();
				us.setName("Admin");
				session.setAttribute("userobj", us);
				resp.sendRedirect("admin/home.jsp");
			}else {
				User us =dao.login(email, password);
				if(us!=null) {
					session.setAttribute("userobj", us);
					resp.sendRedirect("index.jsp");
					
				}else {
					session.setAttribute("failedMsg", "Email or password is incorrect");
					resp.sendRedirect("login.jsp");
				}
				
				
			}
			
			
			
	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

}
