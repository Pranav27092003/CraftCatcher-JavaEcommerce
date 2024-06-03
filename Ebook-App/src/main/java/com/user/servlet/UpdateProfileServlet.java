package com.user.servlet;

import java.io.IOException;

import org.apache.catalina.ant.jmx.JMXAccessorQueryTask;

import com.DAO.UserDaoImpl1;
import com.DB.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/updateprofile")
public class UpdateProfileServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");
			
			User us = new User();
			us.setId(id);
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			
			HttpSession session = req.getSession();
			UserDaoImpl1 dao = new UserDaoImpl1(DBConnect.getConn());
			
			boolean f =	dao.checkPassword(id, password);
			if(f) {
				
				boolean f2 = dao.updateprofile(us);
				if(f2) {
					session.setAttribute("succMsg","Profile Updated Successfully !!");
					resp.sendRedirect("editprofile.jsp");
				}else {
					session.setAttribute("failMsg","Some error in server");
					resp.sendRedirect("editprofile.jsp");
				}
			}else {
				session.setAttribute("failMsg","Your password is incorrect ");
				resp.sendRedirect("editprofile.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
