package com.controller;

import java.io.IOException;
import java.util.List;

import com.daoImpl.ProductDaoImpl;
import com.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class GetProducts extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDaoImpl pdi=new ProductDaoImpl();
		List<Product> productList=pdi.fetchAll();
		HttpSession session=req.getSession();
		session.setAttribute("productList", productList);
		resp.sendRedirect("Home.jsp");
	}
}
