package com.controller;

import java.io.IOException;

import com.SecureData.SecureData;
import com.daoImpl.UserDaoImpl;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=SecureData.encrypt(req.getParameter("username"));
		String email=SecureData.encrypt(req.getParameter("email"));
		String password=SecureData.encrypt(req.getParameter("password"));
		String address=SecureData.encrypt(req.getParameter("address"));
		
		UserDaoImpl udi=new UserDaoImpl();
		User u=new User(userName, email, password, address);
		if(udi.insert(u)==1) {
			resp.getWriter().println("Registered sucessfully");
		}
		else {
			resp.getWriter().print("failed to register");
		}
		
	}
}
