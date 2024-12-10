package com.controller;

import java.io.IOException;

import com.SecureData.SecureData;
import com.daoImpl.UserDaoImpl;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=SecureData.encrypt(req.getParameter("email"));
		String password=SecureData.encrypt(req.getParameter("password"));
		
		UserDaoImpl udi=new UserDaoImpl();
		User user= udi.fetchSpecific(email);
		
		if(email.equals(user.getEmail())) {
			if(password.equals(user.getPassword())) {
				resp.sendRedirect("GetProducts");
				HttpSession session=req.getSession();
				User u=new User(SecureData.decrypt(user.getUserName()),
						SecureData.decrypt(user.getEmail()),
						SecureData.decrypt(user.getPassword()),
						SecureData.decrypt(user.getAddress())
					);
				session.setAttribute("user", u);
			}
			else {
				resp.getWriter().print("password mismatch");
			}
		}
		else {
			resp.getWriter().print("No user found");
		}
		
	}
}
