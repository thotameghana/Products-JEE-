package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.MyConnector;
import com.dao.ProductDao;
import com.model.Product;

public class ProductDaoImpl implements ProductDao{

	private static Connection con;
	private static String fetchAll="select * from product";
	List<Product> products=new ArrayList<>();
	static {
		con=MyConnector.connect();
	}
	private Statement stmt;
	private ResultSet resultSet;
	public List<Product> fetchAll() {
		try {
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(fetchAll);
			while(resultSet.next()) {
				products.add(new Product(
						resultSet.getString("pName"),
						resultSet.getFloat("price"),
						resultSet.getFloat("rating"),
						resultSet.getString("description")	
				));	
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return products;
	}
	
	
}
